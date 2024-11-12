package Repositorios;
import java.util.List;

import modelo.Beneficiario;
import modelo.Poliza;

public interface beneficiarioRepositorio 
{

    public Beneficiario obtenerPorCurp(String curp);
    public List<Beneficiario> obtenerTodos();
    public Beneficiario guardar(Beneficiario guardar);
    public Beneficiario actualizar(Beneficiario beneficiario);
    public void eliminarPorCurp(String curp);
    public List<Poliza> obtenerPolizaDeBeneficiario(String curp);
    public List<Beneficiario> buscarPorNombre(String nombre, String Apellidos);
}