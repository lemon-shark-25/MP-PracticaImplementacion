/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class Challenge {
	
    private Administrator validatedBy;    
    private ChallengeState state;
	private final Player defyingPlayer;
	private final Player defiedPlayer;
	private final int betGold;

    public Challenge(Player defyingPlayer,
                     Player defiedPlayer,
                     int betGold) {
        this.defyingPlayer = defyingPlayer;
        this.defiedPlayer = defiedPlayer;
        this.betGold = betGold;
        this.state = ChallengeState.PENDING_ADMIN_VALIDATION;
    }
	
	// Getters
	public Player getDefyingPlayer() {
		return defyingPlayer;
	}

	public Player getDefiedPlayer() {
		return defiedPlayer;
	}

	public int getBetGold() {
		return betGold;
	}

	public ChallengeState getState() {
		return state;
	}

	void validateByAdmin(Administrator admin) {
		this.validatedBy = admin;
		this.state = ChallengeState.PENDING_PLAYER_RESPONSE;
	}

	void denyByAdmin(Administrator admin) {
		this.validatedBy = admin;
		this.state = ChallengeState.DENIED_BY_ADMIN;
	}

	void acceptByPlayer() {
        this.state = ChallengeState.ACCEPTED;
    }

    void rejectByPlayer() {
        this.state = ChallengeState.REJECTED;
    }

    void finish() {
        this.state = ChallengeState.FINISHED;
    }
}
