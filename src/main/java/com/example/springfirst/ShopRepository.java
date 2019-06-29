package com.example.springfirst;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Long> {

    @Query("select p.product, SUM(p.number), SUM(p.tot_price)/SUM(p.number),"
            + " SUM(p.tot_price)"
            + " from Shop p where p.code=:code group by p.product order by p.code")
    List<Tuple> findByCodeAvgTotPrice(@Param("code") int code);
}
