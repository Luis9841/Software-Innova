package Servicios;
import java.util.List;

import modelo.Cliente;
import modelo.Poliza;

public class ClienteService 
{
 
    public Cliente obtenerPorCurp(String curp)
    {

        Cliente cliente = null;
        // cliente = buscarPorCurp(curp)
        return cliente;
    }


    public List<Cliente> obtenerTodos()
    {
        List<Cliente> clientes = null;
        // clientes = buscar todos los clientes

        return clientes;
    }


    public void guardar(Cliente cliente)
    {
        System.out.println("Cliente Guardado...");
    }


    public void actualizar(Cliente cliente)
    {
        System.out.println("Cliente Actualizado...");
    }

    public void eliminarPorCurp(String curp)
    {
        System.out.println("Cliente con Curp: " + curp + "Eliminado");
    }

    public List<Poliza> obtenerPolizasDeCliente(String curp)
    {
        List<Poliza> polizas = null;

        return polizas;
    }

    public List<Cliente> buscarPorNombreOApellidos(String nombre, String apellidos)
    {
        List<Cliente> clientes = null;

        return clientes;
    }

}
