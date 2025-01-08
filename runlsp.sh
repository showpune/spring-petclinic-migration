podman run -v $(pwd)/result.yaml:/analyzer-lsp/output.yaml:Z \
           -v $(pwd)/provider_settings.json:/analyzer-lsp/provider_settings.json \
           -v $(pwd)/rule-in-one.yaml:/analyzer-lsp/rule-example.yaml \
           -v $(pwd):/analyzer-lsp/examples/spring-petclinic \
           quay.io/konveyor/analyzer-lsp
