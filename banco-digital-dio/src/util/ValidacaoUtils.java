package util;

public class ValidacaoUtils {
    public static boolean validarCPF(String cpf) {
        // Implementação simplificada
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
    }
}