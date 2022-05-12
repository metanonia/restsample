package com.metanonia.restsample.respository;

import com.metanonia.restsample.model.Depth;
import com.metanonia.restsample.model.DepthId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepthRepository extends JpaRepository<Depth, DepthId> {
}
