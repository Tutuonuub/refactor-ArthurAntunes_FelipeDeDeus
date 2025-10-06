package com.exemplo.notificacao.notifier;

import com.exemplo.notificacao.model.Pedido;

public interface Notificador { // Comentário de Revisão: Esta interface define o contrato para as estratégias de notificação, fundamental para o padrão Strategy.
    void enviar(Pedido pedido);
    String nome(); // opcional, útil para logs/revisões
}