package com.exemplo.notificacao.service;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.notifier.Notificador;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements Notificador { // Comentário de Revisão: Esta classe é uma implementação concreta da estratégia de notificação por e-mail.
    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Enviando e-mail para " + pedido.getCliente());
    }

    @Override
    public String nome() {
        return "email";
    }
}