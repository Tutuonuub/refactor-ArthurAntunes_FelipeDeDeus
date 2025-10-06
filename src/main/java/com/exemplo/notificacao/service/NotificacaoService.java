package com.exemplo.notificacao.service;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.notifier.Notificador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    private final List<Notificador> notifiers;

    public NotificacaoService(List<Notificador> notifiers) {
        this.notifiers = notifiers;
    }

    public void enviarNotificacoes(Pedido pedido) {
        // Comentário de Revisão: A injeção de uma lista de Notificador no construtor é uma excelente aplicação do padrão Strategy.
        // Isso permite adicionar novas formas de notificação sem modificar esta classe (Princípio Open/Closed).

        // percorre todos os notifiers registrados pelo Spring
        for (Notificador n : notifiers) {
            try {
                n.enviar(pedido);
            } catch (Exception e) {
                // log simples para não interromper notificações restantes
                System.err.println("Erro ao enviar via " + n.nome() + ": " + e.getMessage()); // Comentário de Revisão: O tratamento de exceções individual para cada notificador é uma boa prática para garantir a resiliência do sistema, permitindo que outras notificações continuem mesmo se uma falhar.
            }
        }
    }
}