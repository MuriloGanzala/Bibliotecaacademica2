import java.time.LocalDate;

public class Principal {
    private Livro livro1;
    private Livro livro2;
    private Emprestimo emprestimo1;

    public void adicionarLivro1(Livro livro) {
        this.livro1 = livro;
        System.out.println("Livro 1 adicionado: " + livro.getTitulo());
    }

    public void adicionarLivro2(Livro livro) {
        this.livro2 = livro;
        System.out.println("Livro 2 adicionado: " + livro.getTitulo());
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        this.emprestimo1 = emprestimo;
        System.out.println("Empréstimo registrado: " + emprestimo.getLivro().getTitulo() + " para " + emprestimo.getUsuario().getNome());
    }

    public void listarLivros() {
        System.out.println("Livros na biblioteca:");
        if (livro1 != null) {
            System.out.println("- " + livro1.getTitulo() + " (Autor: " + livro1.getAutor().getNome() + ")");
        }
        if (livro2 != null) {
            System.out.println("- " + livro2.getTitulo() + " (Autor: " + livro2.getAutor().getNome() + ")");
        }
    }

    public void listarEmprestimos() {
        if (emprestimo1 != null) {
            System.out.println("Empréstimo: Livro '" + emprestimo1.getLivro().getTitulo() + "' para " + emprestimo1.getUsuario().getNome() +
                    " em " + emprestimo1.getDataEmprestimo() + " com devolução prevista para " + emprestimo1.getDataDevolucao());
        }
    }


    public class Emprestimo {
        private Livro livro;
        private Usuario usuario;
        private LocalDate dataEmprestimo;
        private LocalDate dataDevolucao;

        public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = dataEmprestimo;
            this.dataDevolucao = dataDevolucao;
        }

        // Getters
        public Livro getLivro() {
            return livro;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataDevolucao() {
            return dataDevolucao;
        }
    }

    public void executar() {
        Autor autor1 = new Autor("J.K. Rowling");
        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", autor1);

        Autor autor2 = new Autor("George Orwell");
        Livro livro2 = new Livro("1984", autor2);

        adicionarLivro1(livro1);
        adicionarLivro2(livro2);

        Usuario usuario1 = new Usuario("João Silva");
        Emprestimo emprestimo1 = new Emprestimo(livro1, usuario1, LocalDate.now(), LocalDate.now().plusDays(7));

        registrarEmprestimo(emprestimo1);

        listarLivros();
        listarEmprestimos();
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.executar();
    }
}
