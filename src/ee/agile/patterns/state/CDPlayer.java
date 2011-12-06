package ee.agile.patterns.state;

import static ee.agile.patterns.state.CDPlayer.State.*;

public class CDPlayer {
    enum State {
        EJECTED {
            public State eject() { return NO_DISC; /* or IDLE */ }
        },
        NO_DISC {
            public State eject() { return EJECTED; }
        },
        IDLE {
            public State eject() { return EJECTED; }
            public State play() { return PLAYING; }
        },
        PLAYING {
            public State eject() { return EJECTED; }
            public State pause() { return PAUSED; }
            public State play() { return PAUSED; }
            public State next() { return this; /* + next track */ }
            public State prev() { return this; /* + next track */ }
            public State stop() { return IDLE; }
        },
        PAUSED {
            public State pause() { return PLAYING; }
            public State play() { return PLAYING; }
        };

        public State eject() {return this;}
        public State play() {return this;}
        public State pause() {return this;}
        public State next() {return this;}
        public State prev() {return this;}
        public State stop() {return this;}
    }

    private State state = NO_DISC;

    public void eject() {
        state = state.eject();
    }

    public void play() {
        state = state.play();
    }

    public void pause() {
        state = state.pause();
    }

    public void next() {
        state = state.next();
    }

    public void prev() {
        state = state.prev();
    }

    public void stop() {
        state = state.stop();
    }

    public boolean isDiscInside() {
        return state != NO_DISC;
    }

    public boolean isPlaying() {
        return state == PLAYING;
    }

    public int getTrackNumber() {
        return 1;
    }
}
