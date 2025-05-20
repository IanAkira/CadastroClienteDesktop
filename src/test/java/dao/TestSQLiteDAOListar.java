package dao;

import dao.cliente.ClienteDAO;
import entidade.Cliente;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestSQLiteDAOListar {

    @Test
    void testListarQuantidade() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();

        Cliente cliente1 = new Cliente("1", "Joao", "11111111");
        Cliente cliente2 = new Cliente("2", "maria", "22222222");

        clientedao.inserir(cliente1);
        clientedao.inserir(cliente2);

        int quantidadeEsperada = 2;

        int quantidadeRecuperada = clientedao.getLista().size();

        assertEquals(quantidadeEsperada, quantidadeRecuperada);

        clientedao.excluir(cliente1);
        clientedao.excluir(cliente2);

    }

    @Test
    void testListarDados() {

        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();

        Cliente cliente1 = new Cliente("1", "Joao", "11111111");

        clientedao.inserir(cliente1);


        List clientes = clientedao.getLista();
        Cliente clienterecuperado = (Cliente)clientes.get(0);
        


        assertEquals(cliente1.getCliente_id(), clienterecuperado.getCliente_id());
        assertEquals(cliente1.getNome(), clienterecuperado.getNome());
        assertEquals(cliente1.getCPF(), clienterecuperado.getCPF());

        clientedao.excluir(cliente1);


    }

}
