package validações;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaNomeUser {

    public static boolean validaNomeUser(String nome) {
        String regx = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        return matcher.find();
    }
}
