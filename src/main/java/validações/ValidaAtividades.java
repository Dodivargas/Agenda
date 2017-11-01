package validações;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaAtividades {


    public static boolean ValidaHoraAtiviade(String hora){
        String regx = "^[0-2][0-3]:[0-5][0-9]$\n";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hora);

        return matcher.find();
    }
    public static boolean validaNomeAtividade(String nome){
        String regx = "^[\\\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);

        return matcher.find();
    }
    public static boolean validadeTipoAtividade(String tipo){
        String regx = "^[\\\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(tipo);

        return matcher.find();
    }
}
