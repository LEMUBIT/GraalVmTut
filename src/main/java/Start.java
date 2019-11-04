import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Start {
    public static void main(String[] args) throws Exception {

        Context context = Context.newBuilder().allowAllAccess(true).build();

        URL jsResource = Thread.currentThread().getContextClassLoader().getResource("Say.py");
        String content = new String(Files.readAllBytes(Paths.get(jsResource.toURI())));

        context.eval("python", content);
        Value result = context.eval("python", "say()");
        System.out.println(result);
    }
}
