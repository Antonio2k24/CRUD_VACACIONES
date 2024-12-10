package com.idat.personalplanta.repository;

import com.idat.personalplanta.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value = "SELECT e.* FROM tb_empleado e INNER JOIN tb_emp_capa ec on e.id_empleado=ec.id_empleado WHERE ec.id_capacitacion=:idCapacitacion", nativeQuery = true)
    List<Empleado> findAllByCapacitacionId(@Param("idCapacitacion") Integer idCapacitacion);
}
