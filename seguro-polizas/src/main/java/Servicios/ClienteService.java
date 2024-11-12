package Servicios;
import java.util.List;

import modelo.Cliente;
import modelo.Poliza;
import Repositorios.clienteRepositorio;

public class ClienteService implements clienteRepositorio
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


    public Cliente guardar(Cliente cliente)
    {
        System.out.println("Cliente Guardado...");
        return cliente;
    }


    public Cliente actualizar(Cliente cliente)
    {
        Cliente cliente2 = cliente;        
        System.out.println("Cliente Actualizado...");

        return cliente2;
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
