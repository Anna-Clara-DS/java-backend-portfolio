import java.util.ArrayList;
import java.util.List;

public class UsuarioControlador {
    private List<UsuarioModelo> usuarios = new ArrayList<>();

    public UsuarioControlador() {
        // Contas pré-cadastradas
        usuarios.add(new UsuarioModelo("001", "Alice", 1000.0));
        usuarios.add(new UsuarioModelo("002", "Bruno", 500.0));
        usuarios.add(new UsuarioModelo("003", "Carla", 1500.0));
    }

    public List<UsuarioModelo> listarUsuarios() {
        return usuarios;
    }

    public UsuarioModelo buscarUsuarioPorConta(String numeroConta) {
        for (UsuarioModelo u : usuarios) {
            if (u.getNumeroConta().equals(numeroConta)) {
                return u;
            }
        }
        return null;
    }

    public boolean depositar(String numeroConta, double valor) {
        UsuarioModelo u = buscarUsuarioPorConta(numeroConta);
        if (u != null) {
            u.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean sacar(String numeroConta, double valor) {
        UsuarioModelo u = buscarUsuarioPorConta(numeroConta);
        if (u != null) {
            return u.sacar(valor);
        }
        return false;
    }

    public boolean transferir(String contaOrigem, String contaDestino, double valor) {
        UsuarioModelo origem = buscarUsuarioPorConta(contaOrigem);
        UsuarioModelo destino = buscarUsuarioPorConta(contaDestino);

        if (origem != null && destino != null) {
            return origem.transferir(destino, valor);
        }
        return false;
    }
}
