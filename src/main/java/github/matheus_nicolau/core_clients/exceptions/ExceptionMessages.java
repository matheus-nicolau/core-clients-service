package github.matheus_nicolau.core_clients.exceptions;

public enum ExceptionMessages {
    CLIENT_ALREADY_EXISTS("Usuário já cadastrado."),
    CLIENT_NOT_FINDED("Cliente Não encontrado."),
    CREDIT_SOLICITATION_NOT_FOUND("Solicitação de crédito não pode ser concluída.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
