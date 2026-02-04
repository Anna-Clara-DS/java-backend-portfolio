public class Main {
    public static void main(String[] args) {
        UsuarioControlador controlador = new UsuarioControlador();
        UsuarioVisao visao = new UsuarioVisao(controlador);

        visao.exibirMenu();
    }
}

git clone 