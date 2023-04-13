package com.clienteCred.clienteCred.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteCred.clienteCred.DTOs.EmprestimoDTO;
import com.clienteCred.clienteCred.model.CadastroEmprestimo;
import com.clienteCred.clienteCred.service.CadastroEmprestimoService;

@RestController
@RequestMapping("/clientes")
public class CadastroEmprestimoController {

    @Autowired
    private CadastroEmprestimoService cadastroEmprestimoService;

    @PostMapping("/{cpf}/emprestimos")
    public ResponseEntity<CadastroEmprestimo> adicionarEmprestimo(@PathVariable String cpf,
                                                                  @RequestBody CadastroEmprestimo novoEmprestimo) {
        CadastroEmprestimo emprestimo = cadastroEmprestimoService.adicionarEmprestimo(cpf, novoEmprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
    }

    @DeleteMapping("/{cpf}/emprestimos/{id}")
    public ResponseEntity<Void> removerEmprestimo(@PathVariable String cpf, @PathVariable Long id) {
        cadastroEmprestimoService.removerEmprestimo(cpf, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}/emprestimos/{id}")
    public ResponseEntity<EmprestimoDTO> buscarEmprestimo(@PathVariable String cpf, @PathVariable Long id) {
        EmprestimoDTO emprestimoDTO = cadastroEmprestimoService.buscarEmprestimo(cpf, id);
        return ResponseEntity.ok(emprestimoDTO);
    }

    @GetMapping("/{cpf}/emprestimos")
    public ResponseEntity<List<CadastroEmprestimo>> listarEmprestimos(@PathVariable String cpf) {
        List<CadastroEmprestimo> emprestimos = cadastroEmprestimoService.listarEmprestimos(cpf);
        return ResponseEntity.ok(emprestimos);
    }
}
