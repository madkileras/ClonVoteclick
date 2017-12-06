package cl.voteclick.services;

import cl.voteclick.model.Voter;
import cl.voteclick.repositories.VoterRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;



@CrossOrigin
@RestController
@RequestMapping("/voters")
public class VoterService {
    @Autowired
    VoterRepository voterRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Voter create(@RequestBody Voter resource){
        return voterRepository.save(resource);
    }
	
	@RequestMapping(method = RequestMethod.POST,value="/validate")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Voter validar(@RequestBody HashMap<String,String> resource){
    	String correo = resource.get("email");
    	String pass = resource.get("password");
    	Voter v = voterRepository.findByEmailAndPassword(correo,pass);
    	return v;
    }
    


    @RequestMapping(method = RequestMethod.POST, value= "/auth")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public boolean Auth(@RequestBody HashMap<String,String> resource) throws IOException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {

                    public java.security.cert.X509Certificate[] getAcceptedIssuers()
                    {
                        return null;
                    }
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                    {
                        //No need to implement.
                    }
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                    {
                        //No need to implement.
                    }
                }
        };


        try
        {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e)
        {
            System.out.println("Error de validación");
        }

        URL url = new URL("https://portal.sidiv.registrocivil.cl/usuarios-portal/pages/DocumentRequestStatus.xhtml?RUN=" + resource.get("run") +"&type=CEDULA&serial="+resource.get("ndoc"));
        HttpsURLConnection conn= (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd= new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line=rd.readLine())!=null){
            if(line.contains("Vigente")){
                return true;
            }
        }
        return false;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validate/{email}")
    @ResponseBody
    public Voter getVoter(@PathVariable("email") String email){
        System.out.println(voterRepository.findByEmail(email));
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Voter getVoterId(@PathVariable("id") Long id){
        return (voterRepository.findOne(id));
    }



}
