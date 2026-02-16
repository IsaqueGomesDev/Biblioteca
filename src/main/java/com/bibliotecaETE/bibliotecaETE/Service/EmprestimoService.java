package com.bibliotecaETE.bibliotecaETE.Service;

import com.bibliotecaETE.bibliotecaETE.Model.EmprestimoModel;
import com.bibliotecaETE.bibliotecaETE.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public EmprestimoModel salvar(EmprestimoModel emprestimo) {
        return repository.save(emprestimo);
    }

    public List<EmprestimoModel> listarPorPrioridade() {
        return repository.findAllByOrderByDataVencimentoAsc();
    }

    public List<EmprestimoModel> listarAtrasados() {
        return repository.findByDataVencimentoBefore(LocalDate.now());
    }
}