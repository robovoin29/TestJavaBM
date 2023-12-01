package testtask3;

import java.util.ArrayList;

class PlayerInfo {
    private ArrayList<Integer> sequence;
    private Integer curIdxSkip;
    PlayerInfo(ArrayList<Integer> seq) {
        this.sequence = seq;
    }

    public void setCurIdxSkip(Integer curIdxSkip) {
        this.curIdxSkip = curIdxSkip;
    }

    public Integer getCurIdxSkip() {
        return this.curIdxSkip;
    }

    public ArrayList<Integer> getSequence() {
        return this.sequence;
    }
}
