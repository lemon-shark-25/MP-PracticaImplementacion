/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public enum ChallengeState {
	PENDING_ADMIN_VALIDATION,
    DENIED_BY_ADMIN,
    PENDING_PLAYER_RESPONSE,
    ACCEPTED,
    REJECTED,
    FINISHED
}
