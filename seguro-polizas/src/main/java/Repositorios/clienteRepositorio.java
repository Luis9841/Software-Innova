package Repositorios;
import java.util.List;

import modelo.Cliente;
import modelo.Poliza;



public interface clienteRepositorio 
{

    public Cliente obtenerPorCurp(String curp);
    public List<Cliente> obtenerTodos();
    public Cliente guardar(Cliente cliente);
    public Cliente actualizar(Cliente cliente);
    public void eliminarPorCurp(String curp);
    public List<Poliza> obtenerPolizasDeCliente(String curp);
    public List<Cliente> buscarPorNombreOApellidos(String nombre, String Apellidos);
}
