package com.artsaboaria.repositorio;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Voucher_Ent;

public interface VoucherRepositorio extends JpaRepository<Voucher_Ent, Long> {
	
	public Optional<Voucher_Ent> findByNome(String nome);

}
