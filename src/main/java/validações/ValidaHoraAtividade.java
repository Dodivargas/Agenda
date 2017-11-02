package validações;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaHoraAtividade {

    public static boolean ValidaHoraAtiviade(String hora){
        String regx = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hora);
        return matcher.find();
    }
}
