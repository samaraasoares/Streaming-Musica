# 🎵 Sistema de Streaming de Música 

Este projeto é uma simulação de uma plataforma de streaming de música desenvolvida em Java, focada na aplicação prática de **Polimorfismo**, **Herança** e **Tratamento de Coleções Polimórficas**.

##  Funcionalidades

###  Gestão de Usuários
- **Usuário Free:** Possui limite de criação de até 3 playlists e ouve anúncios a cada 3 músicas reproduzidas.
- **Usuário Premium:** Sem anúncios, reprodução em alta qualidade e funcionalidade exclusiva de download de músicas.
- **Sistema Multi-usuário:** Permite cadastrar múltiplos perfis e alternar entre eles (Login/Logout).

###  Playlists
- **Playlist Personalizada:** Criada manualmente pelo usuário com nome e descrição.
- **Playlist Automática:** Gerada pelo sistema com base em um critério (Gênero Musical), filtrando automaticamente o banco de músicas global.

### Estatísticas do Sistema
- O sistema rastreia o uso global e diferencia o engajamento entre usuários Free e Premium.
- Exibe porcentagem de reproduções por tipo de conta.
- Contador global de anúncios exibidos.

##  Conceitos de POO Aplicados (Critérios de Avaliação)

- **Polimorfismo:** Utilizado para tratar `UsuarioFree` e `UsuarioPremium` como a classe base `Usuario`, permitindo que o método `reproduzirMusica()` se comporte de forma diferente para cada um.
- **Sobrescrita (@Override):** Aplicada em todos os métodos de reprodução e gestão de playlists para garantir comportamentos específicos.
- **Instanceof e Casting:** Utilizados no sistema de estatísticas e na funcionalidade de download para identificar o tipo real do objeto em tempo de execução.
- **Palavra-chave `final`:** Aplicada em métodos de leitura (getters) e constantes de limite para garantir a integridade dos dados.
- **Coleções Polimórficas:** Uso de `ArrayList<Usuario>` e `ArrayList<Playlist>` para gerenciar diferentes subclasses em uma única lista.

##  Estrutura do Projeto

```text
CP5-Streaming/
├── Musica.java               # Classe base das músicas
├── Playlist.java             # Superclasse das playlists
├── PlaylistPersonalizada.java # Subclasse para playlists do usuário
├── PlaylistAutomatica.java    # Subclasse com lógica de filtro por gênero
├── Usuario.java              # Superclasse com atributos comuns
├── UsuarioFree.java          # Implementação com anúncios e limites
├── UsuarioPremium.java       # Implementação com alta qualidade e download
└── StreamingMusica.java      # Classe principal (Menu e Lógica de Sistema)
