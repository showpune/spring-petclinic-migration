podman run -v $(pwd)/result-in-one.yaml:/analyzer-lsp/output.yaml:Z \
           -v $(pwd)/provider_settings.json:/analyzer-lsp/provider_settings.json \
           -v $(pwd)/rule-in-one.yaml:/analyzer-lsp/rule-example.yaml \
           -v $(pwd):/analyzer-lsp/examples/spring-petclinic \
           showpune/lsp:v1
