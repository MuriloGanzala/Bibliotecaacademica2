public class Usuario {
    private String nome;
    private String matricula;

    public Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Usuario(String joãoSilva) {
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
}
