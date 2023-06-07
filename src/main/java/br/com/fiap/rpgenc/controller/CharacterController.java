package br.com.fiap.rpgenc.controller;

import br.com.fiap.rpgenc.model.character.DadosAlteracaoCharacter;
import br.com.fiap.rpgenc.model.character.DadosCadastroCharacter;
import br.com.fiap.rpgenc.model.character.Character;
import br.com.fiap.rpgenc.model.character.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var character = repository.getReferenceById(id);
            model.addAttribute("character", character);
        }
        return "characters/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "characters/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCharacter(DadosCadastroCharacter dados) {
        var character = new Character(dados);
        repository.save(character);

        return "redirect:/characters";
    }

    @PutMapping
    @Transactional
    public String alteraCharacter(DadosAlteracaoCharacter dados) {
        var character = repository.getReferenceById(dados.id());
        character.atualizaDados(dados);

        return "redirect:/characters";
    }

    @DeleteMapping
    @Transactional
    public String removeCharacter(Long id) {
        repository.deleteById(id);

        return "redirect:/characters";
    }
}
