private static void exibirEstatisticas() {
    int qtdFree = 0, qtdPremium = 0;
    int reprodFree = 0, reprodPremium = 0;
    
    System.out.println("\n=== ESTATÍSTICAS DETALHADAS DO SISTEMA ===");
    
    for (Usuario u : usuarios) {
        if (u instanceof UsuarioFree) {
            qtdFree++;
            reprodFree += u.getReproducoesIndividuais();
        } else if (u instanceof UsuarioPremium) {
            qtdPremium++;
            reprodPremium += u.getReproducoesIndividuais();
            System.out.println("-> Assinante: " + u.getNome() + " (Plano " + ((UsuarioPremium) u).getTipoPlano() + ")");
        }
    }
    
    int total = Usuario.totalReproducoesSistema;

    double percFree = (total > 0) ? (reprodFree * 100.0 / total) : 0;
    double percPremium = (total > 0) ? (reprodPremium * 100.0 / total) : 0;

    System.out.println("------------------------------------");
    System.out.println("Total de usuários: " + usuarios.size());
    System.out.println("Contas Free: " + qtdFree + " | Contas Premium: " + qtdPremium);
    System.out.println("\nReproduções totais: " + total);
    System.out.printf("- Free: %d (%.1f%%)\n", reprodFree, percFree);
    System.out.printf("- Premium: %d (%.1f%%)\n", reprodPremium, percPremium);
    System.out.println("Total de anúncios exibidos: " + UsuarioFree.totalAnunciosExibidos);
    System.out.println("------------------------------------");
}
