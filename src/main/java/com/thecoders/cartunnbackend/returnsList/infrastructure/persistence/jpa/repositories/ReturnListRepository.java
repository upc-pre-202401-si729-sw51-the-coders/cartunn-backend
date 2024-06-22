package com.thecoders.cartunnbackend.returnsList.infrastructure.persistence.jpa.repositories;

import com.thecoders.cartunnbackend.productRefunds.domain.model.aggregates.ProductRefund;
import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReturnListRepository  extends JpaRepository<ReturnList,Long> {
    Optional<ReturnList> findByTitle(String tittle);
    boolean existsByTitleAndIdIsNot(String title, Long id);

    boolean existsByTitle(String title);
}
