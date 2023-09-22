package br.com.fiap;

import com.sun.net.httpserver.HttpServer;

import java.net.URI;
import java.util.Map;

public class Main {

    private static final String BASE_URI = "http://localhost/";

    private static HttpServer StartServer() {

        final ResourceConfig rc = new ResourceConfig()
                .packages( "br.com.fiap.domain.resources");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    public static void main(String[] args) {

        final HttpServer server = StartServer();
        System.out.println(
                String.format("Bookstore app started with endpoints available" +
                        "as %s%nHit Ctrl-C to stop it....", BASE_URI)
        );

        try {
            System.in.read();
            server.stop();
        }catch (IDException e){
            throw new RuntimeException(e);
        }
    }


    private static Map<String, Object> getProperties() {


    }
}