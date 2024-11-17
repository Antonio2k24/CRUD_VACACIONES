package com.idat.personalplanta.service;

import com.idat.personalplanta.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> listarEmpleados();
    void guardarEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoPorId(Integer id);
    void eliminarEmpleado(Integer id);
}
