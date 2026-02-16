package com.bibliotecaETE.bibliotecaETE.Controller;
import com.bibliotecaETE.bibliotecaETE.Model.EmprestimoModel;
import com.bibliotecaETE.bibliotecaETE.Service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/biblioteca/emprestimos")
@CrossOrigin(origins = "http://localhost:5500")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmprestimoModel> salvar(@RequestBody EmprestimoModel emprestimo) {
        return ResponseEntity.ok(service.salvar(emprestimo));
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> listar() {
        return ResponseEntity.ok(service.listarPorPrioridade());
    }

    @GetMapping("/atrasados")
    public ResponseEntity<List<EmprestimoModel>> atrasados() {
        return ResponseEntity.ok(service.listarAtrasados());
    }
}
