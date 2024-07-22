package leo.local.gym_exercises.controller.treino;

import leo.local.gym_exercises.domain.model.TreinoDTO;
import leo.local.gym_exercises.services.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/treino")
public class CadastrarTreinoController {

    private final TreinoService treinoService;

    @PostMapping()
    public ResponseEntity<String> cadastrarUsuario(@RequestBody TreinoDTO treinoDTO){
        try {
            treinoService.cadastrarTreino(treinoDTO);
            return ResponseEntity.ok("Treino cadastrado com sucesso");
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), "Não foi possível cadastrar o Treino.");
        }
    }
}
