# 🎵 Sistema de Streaming de Música - Versão 6.0 (Final)

Este projeto é uma simulação completa de uma plataforma de streaming de música desenvolvida em Java, focada na aplicação prática de **Interfaces**, **Encapsulamento Profissional** e **Organização em Pacotes**. Este é o Checkpoint Final (CP6) da disciplina de Programação Orientada a Objetos.

##  Funcionalidades

###  Gestão de Usuários
- **Usuário Free:** Reprodução com anúncios automáticos a cada 3 músicas e estatísticas de uso.
- **Usuário Premium:** Implementa a interface `Baixavel`, permitindo download de músicas, além de reprodução em alta qualidade sem interrupções.

###  Playlists e Reprodução
- **Playlist Automática:** Lógica de filtro que gera listas automaticamente com base em critérios (Gênero Musical) a partir de um banco global.
- **Polimorfismo de Reprodução:** Tanto Músicas quanto Playlists implementam a interface `Reproduzivel`, permitindo um controle unificado de execução.

###  Estatísticas e Serviços
- **Contadores Globais:** Rastreio de anúncios e total de reproduções no sistema através de membros estáticos e encapsulados.
- **Gerador de Recomendações:** Serviço que analisa o histórico do usuário para sugerir novos artistas.
- **Formatador de Tempo:** Utilitário que converte a duração de segundos para o formato `MM:SS`.

##  Conceitos de POO Aplicados

- **Interfaces (`Reproduzivel`, `Baixavel`):** Uso de contratos para garantir comportamentos específicos entre classes diferentes.
- **Encapsulamento:** Atributos privados com acesso via métodos `Getters` e `Setters`, além de métodos `protected` para comunicação segura entre classes pai e filho.
- **Abstração:** Classes base `Usuario` e `ItemReproducao` que definem o esqueleto do sistema.
- **Herança e Polimorfismo:** Especialização de contas (Free/Premium) e itens de áudio (Musica/Playlist).

##  Estrutura de Pacotes (Arquitetura)

```text
src/
└── br/com/streaming/
    ├── modelo/        # Entidades (Musica, Playlist, Usuarios)
    ├── servico/       # Interfaces e Lógica (Reproduzivel, Baixavel, Recomendações)
    ├── util/          # Ajudantes (FormatadorTempo, Validador)
    └── principal/     # Classe Executável (StreamingMusica)
