package se.nackademin.core.repositories.eventrepository.models;

public enum EventType {
	ANSWER_CHOSEN_BUTTON,
	SHOW_GUI,
	SHOW_CATEGORIES_BUTTON,
	CATEGORY_CHOSEN,
	CATEGORY_CHOSEN_BUTTON,
	NEXT_TO_CHOOSE,
	WAITING_FOR_CHOICE,
	OPPONENT_STARTED_NEW_ROUND,
	NEW_ROUND_BUTTON_PRESSED,
	START_ROUND,
	TWO_PLAYERS_CONNECTED,
	CONNECTION_SUCCESS,
	CONNECTION_FAILED,
	START_BUTTON_PRESSED,
	READY, // The sender is ready.
	NEW_ID, // New ID given to the receiver.
	ROUND_FINISHED, SHOW_QUESTION, GAME_FINISHED, INITIAL, EMPTY, GAME_OVER // Game is over.
}
