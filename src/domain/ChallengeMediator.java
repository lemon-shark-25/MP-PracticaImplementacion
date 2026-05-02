/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class ChallengeMediator {
	
	private final List<Challenge> challenges = new LinkedList<>();

    public void registerChallenge(Challenge challenge) {
        challenges.add(challenge);
    }

	public Challenge nextChallengeForAdmin() {
		return challenges.stream()
				.filter(c -> c.getState()
				== ChallengeState.PENDING_ADMIN_VALIDATION)
				.findFirst()
				.orElse(null);
	}

	public void passChallenge(Challenge challenge, Administrator admin) {
		challenge.validateByAdmin(admin);
	}

	public void denyChallenge(Challenge challenge, Administrator admin) {
		challenge.denyByAdmin(admin);
	}

	public List<Challenge> challengesForPlayer(Player player) {
		return challenges.stream()
				.filter(c -> c.getDefiedPlayer().equals(player)
				&& c.getState()
				== ChallengeState.PENDING_PLAYER_RESPONSE)
				.collect(Collectors.toList());
	}
}
