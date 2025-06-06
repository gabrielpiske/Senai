class Projetor {
    constructor() {
        this.resolucao = "1920x1080";
        this.status = false;
    }

    ligar() {
        this.status = true;
        this.setStatus(true);
        log("Projetor ligado - Resolução: " + this.resolucao);
    }
    
    desligar() {
        this.status = false;
        this.setStatus(false);
        log("Projetor desligado");
    }
    
    setStatus(on) {
        const projetorEl = document.getElementById("projetor");
        projetorEl.classList.toggle("on", on);
        document.getElementById("projetorStatus").textContent = on ? "Ligado" : "Desligado";
        document.getElementById("projetorRes").textContent = on ? this.resolucao : "-";
    }
}

class Som {
    constructor() {
        this.volume = 50;
        this.modo = "Stereo";
        this.status = false;
    }

    ligar(modo = "Stereo") {
        this.status = true;
        this.modo = modo;
        this.setStatus(true);
        log(`Som ligado - Modo: ${modo}, Volume: ${this.volume}%`);
    }
    
    desligar() {
        this.status = false;
        this.setStatus(false);
        log("Som desligado");
    }
    
    setVolume(volume) {
        this.volume = volume;
        log(`Volume ajustado para: ${volume}%`);
        document.getElementById("volumeValue").textContent = `${volume}%`;
    }
    
    setStatus(on) {
        const somEl = document.getElementById("som");
        somEl.classList.toggle("on", on);
        document.getElementById("somStatus").textContent = on ? "Ligado" : "Desligado";
        document.getElementById("somMode").textContent = on ? this.modo : "-";
        
        const volumeControl = document.getElementById("volumeControl");
        if (on) {
            volumeControl.classList.add("active");
            document.getElementById("volumeSlider").value = this.volume;
        } else {
            volumeControl.classList.remove("active");
        }
    }
}

class BluRay {
    constructor() {
        this.media = null;
        this.status = false;
        this.tempo = 0;
        this.duracao = 7200; // 2 horas em segundos
    }

    reproduzirFilme() {
        this.media = "Filme";
        this.status = true;
        this.tempo = 0;
        this.setStatus(true);
        log("Reproduzindo filme: 'A Origem' (2010)");
        this.atualizarProgresso();
    }
    
    reproduzirSerie() {
        this.media = "Série";
        this.status = true;
        this.tempo = 0;
        this.setStatus(true);
        log("Reproduzindo série: 'Stranger Things' - S3E5");
        this.atualizarProgresso();
    }
    
    pausar() {
        this.status = false;
        this.setStatus(false);
        log(`Mídia pausada: ${this.media}`);
        clearInterval(this.progressInterval);
    }
    
    setStatus(on) {
        const blurayEl = document.getElementById("bluray");
        blurayEl.classList.toggle("on", on);
        document.getElementById("blurayStatus").textContent = on ? "Reproduzindo" : "Pausado";
        document.getElementById("blurayMedia").textContent = this.media || "-";
        
        const progressBar = document.getElementById("progressBar");
        if (on) {
            progressBar.classList.add("active");
        } else {
            progressBar.classList.remove("active");
            document.getElementById("progress").style.width = "0%";
        }
    }
    
    atualizarProgresso() {
        clearInterval(this.progressInterval);
        
        this.progressInterval = setInterval(() => {
            if (this.tempo < this.duracao) {
                this.tempo += 5;
                const percent = (this.tempo / this.duracao) * 100;
                document.getElementById("progress").style.width = `${percent}%`;
            } else {
                clearInterval(this.progressInterval);
                log(`Fim da reprodução: ${this.media}`);
            }
        }, 100);
    }
}

class Luz {
    constructor() {
        this.intensidade = 100;
        this.status = true;
    }

    escurecer() {
        this.intensidade = 20;
        this.status = true;
        this.setStatus(true);
        log(`Luzes ajustadas para ${this.intensidade}% de intensidade`);
    }
    
    acender() {
        this.intensidade = 100;
        this.status = true;
        this.setStatus(true);
        log("Luzes acesas em 100%");
    }
    
    desligar() {
        this.intensidade = 0;
        this.status = false;
        this.setStatus(false);
        log("Luzes desligadas");
    }
    
    setStatus(on) {
        const luzEl = document.getElementById("luz");
        luzEl.classList.toggle("on", on);
        document.getElementById("luzStatus").textContent = 
            !on ? "Desligada" : this.intensidade <= 20 ? "Atenuada" : "Acesa";
        document.getElementById("luzIntensity").textContent = on ? `${this.intensidade}%` : "0%";
    }
}

class HomeTheaterFacade {
    constructor() {
        this.projetor = new Projetor();
        this.som = new Som();
        this.bluray = new BluRay();
        this.luz = new Luz();
        this.modoAtual = null;
        
        // Configurar eventos
        document.getElementById("volumeSlider").addEventListener("input", (e) => {
            this.som.setVolume(e.target.value);
        });
    }

    assistirFilme() {
        this.resetModos();
        log(">> Iniciando Modo Filme");
        this.modoAtual = "filme";
        document.getElementById("filmeMode").classList.add("active");
        
        this.luz.escurecer();
        this.projetor.ligar();
        this.som.ligar("Dolby Surround 7.1");
        this.bluray.reproduzirFilme();
    }

    assistirSerie() {
        this.resetModos();
        log(">> Iniciando Modo Série");
        this.modoAtual = "serie";
        document.getElementById("serieMode").classList.add("active");
        
        this.luz.escurecer();
        this.projetor.ligar();
        this.som.ligar("Stereo");
        this.bluray.reproduzirSerie();
    }

    ouvirMusica() {
        this.resetModos();
        log(">> Iniciando Modo Música");
        this.modoAtual = "musica";
        document.getElementById("musicaMode").classList.add("active");
        
        this.luz.escurecer();
        this.projetor.desligar();
        this.som.ligar("Hi-Fi Stereo");
        this.bluray.pausar();
    }

    encerrarSessao() {
        this.resetModos();
        log(">> Encerrando Sessão");
        this.modoAtual = "off";
        document.getElementById("offMode").classList.add("active");
        
        this.luz.acender();
        this.projetor.desligar();
        this.som.desligar();
        this.bluray.pausar();
    }
    
    resetModos() {
        this.modoAtual = null;
        document.querySelectorAll(".mode-indicator").forEach(el => {
            el.classList.remove("active");
        });
    }
}

function log(msg) {
    const consoleEl = document.getElementById("console");
    const messageDiv = document.createElement("div");
    messageDiv.innerHTML = `<span style="color: #aaa">${new Date().toLocaleTimeString()}</span> - ${msg}`;
    consoleEl.appendChild(messageDiv);
    consoleEl.scrollTop = consoleEl.scrollHeight;
}

const facade = new HomeTheaterFacade();

// Log inicial
log("Sistema Home Theater inicializado");
log("Selecione um modo para começar");