package com.tazine.boot.repository;

import com.tazine.boot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * PlayerRepository
 *
 * @author frank
 * @since 1.0.0
 */
public interface PlayerRepository extends JpaRepository<Player,Integer>{

    public List<Player> findByName(String name);

}
