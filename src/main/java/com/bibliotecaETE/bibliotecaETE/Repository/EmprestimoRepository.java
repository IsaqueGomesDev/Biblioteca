package com.bibliotecaETE.bibliotecaETE.Repository;
import com.bibliotecaETE.bibliotecaETE.Model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {
    List<EmprestimoModel> findAllByOrderByDataVencimentoAsc();
    List<EmprestimoModel> findByDataVencimentoBefore(LocalDate hoje);
    List<EmprestimoModel> findByLivroId(Long livroId);
    List<EmprestimoModel> findByAlunoId(Long alunoId);
}

