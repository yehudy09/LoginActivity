import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;


public class main {

    static String admin =  "admin";
    static String pass = "1234";


    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.routes(() ->{
            path("/", ()->{
                get("/", ctx ->{
                    ctx.redirect("/login.html");
                });
            });

           path("/", ()->{
              get("/login.html", ctx ->{
                    ctx.render("/login.html");
              });
           });

           path("/", ()->{
                post("/login.html", ctx -> {
                    if (ctx.formParam("usuario").equalsIgnoreCase(admin) && ctx.formParam("contrasena").equalsIgnoreCase(pass)){
                        System.out.println("Login exitoso");
                    }
                });
           });
        });
    }

}
