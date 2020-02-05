import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class PlayUno
	{
		
		static boolean turnTwo;
		static ArrayList<Cards> playerOne = new ArrayList<Cards>();
		static ArrayList<Cards> playerTwo = new ArrayList<Cards>();
		static ArrayList<Cards> currentCard = new ArrayList<Cards>();

		public static void main(String[] args)
			{
				Deck.fillDeck();
				Collections.shuffle(Deck.deck);

				dealCards();
				playUno();

			}

		public static void displayDeck()
			{
				for (Cards c : PlayUno.playerOne)
					{
						System.out.println(c.getColor() + " " + c.getNumber());
					}
			}

		public static void dealCards()
			{
				for (int i = 0; i < 7; i++)
					{
						playerOne.add(Deck.deck.get(i));
						Deck.deck.remove(i);
					}
				for (int i = 0; i < 7; i++)
					{
						playerTwo.add(Deck.deck.get(i));
						Deck.deck.remove(i);
					}

				currentCard.add(Deck.deck.get(0));
				Deck.deck.remove(0);

			}

		public static void playUno()
			{
				boolean play = true;
				boolean playOne = true;
				boolean playTwo = true;
				int choice = 0;

				while (play)
					{

						while (playOne)
							{
								System. out. flush();
								playTwo = true;
								choice = 0;
								int reverse = 1;
								int counter = 0;
								System.out.println("The current card is " + currentCard.get(0).getColor() + " "
										+ currentCard.get(0).getNumber());
								System.out.println(" ");
								System.out.println("Player Ones turn");
								System.out.println(" ");
								System.out.println("You have " + playerOne.size() + " cards left");
								System.out.println(" ");
								System.out.println("** PLAYABLE CARDS **");
								
								for (int i = 0; i < playerOne.size(); i++)
									{
										if (currentCard.get(0).getColor() == playerOne.get(i).getColor())
												 
											{
												counter++;

												System.out
														.println("Type " + i + " to play " + playerOne.get(i).getColor()
																+ " " + playerOne.get(i).getNumber());

											}
										
										if (currentCard.get(0).getNumber() == playerOne.get(i).getNumber())
											 
											{
												counter++;

												System.out
														.println("Type " + i + " to play " + playerOne.get(i).getColor()
																+ " " + playerOne.get(i).getNumber());

											}
										

									}
								for (int i = 0; i < playerOne.size(); i++)
									{
										if (playerOne.get(i).getColor() == "Wild")
											{
												counter++;
												Scanner userIntInput = new Scanner(System.in);
												System.out
														.println("Type " + i + " to play " + playerOne.get(i).getColor()
																+ " " + playerOne.get(i).getNumber());

											}
									}
								
								
								

								if (counter > 0)
									{
										System.out.println(" ");
										Scanner userIntInput = new Scanner(System.in);
										System.out.println("Type Number of card you want to play");
										choice = userIntInput.nextInt();
										currentCard.remove(0);
										currentCard.add(playerOne.get(choice));

										if (playerOne.get(choice).getNumber() == "Draw 4"
												)
											{
												System.out.println("");
												Scanner userIntInput2 = new Scanner(System.in);
												System.out.println(
														"Player 2 Draws 4 Cards and COLOR CHANGE, Type 1 for Blue, Type 2 for Red, Type 3 for Yellow, Type 4 for Green ");
												int colorChoice = userIntInput2.nextInt();
												if (colorChoice == 1)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Blue", "Wild"));
													}

												if (colorChoice == 2)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Red", "Wild"));
													}

												if (colorChoice == 3)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Yellow", "Wild"));
													}

												if (colorChoice == 4)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Green", "Wild"));
													}
												for (int i = 0; i < 4; i++)

													{
														playerOne.add(Deck.deck.get(i));
														Deck.deck.remove(i);
													}
												
											}
										if (playerOne.get(choice).getNumber() == "Color Change")
											{
												System.out.println("");
												Scanner userIntInput3 = new Scanner(System.in);
												System.out.println(
														"COLOR CHANGE. Type 1 for Blue, Type 2 for Red, Type 3 for Yellow, Type 4 for Green");
												int colorChoice2 = userIntInput3.nextInt();

												

												if (colorChoice2 == 1)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Wild", "Blue"));
													}

												if (colorChoice2 == 2)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Wild", "Red"));
													}

												if (colorChoice2 == 3)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Wild", "Yellow"));
													}

												if (colorChoice2 == 4)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Wild", "Green"));
													}
											}
										System.out.println("");
										
										if (playerOne.get(choice).getNumber() == "Draw 2")
											{
												System.out.println("Player Two Draws 2 cards");
												for(int i = 0; i < 2; i++)
													{
														playerTwo.add(Deck.deck.get(i));
														Deck.deck.remove(i);
													}
											}
										if (playerOne.get(choice).getNumber() == "Reverse"
												|| playerOne.get(choice).getNumber() == "Skip")
											{
												playerOne.remove(choice);	
												System.out.println("Turn Skipped. Player Two plays again");
												reverse = 0;
											}
										playerOne.remove(choice);
									}

								
								

								
								
								
								if(playerOne.size() == 1)
									{
										Scanner userStringInput3= new Scanner(System.in);
										System.out.println("You have 1 card left type UNO");
										String UNO = userStringInput3.nextLine();
										if (UNO == "UNO")
											{
												System.out.println("PLAYER ONE HAS ONE CARD LEFT");
											}
									}
								
								if(playerOne.size() == 0)
									{
										System.out.println("PLAYER ONE WINS");
										play = false;
									}

								if (counter == 0)
									{

										
										System.out.println(
												"you have no playable cards, type 1 to add a card to your deck");
										System.out.println("Player 1 Draws 1 Card");
										playerOne.add(Deck.deck.get(0));
										Deck.deck.remove(0);
										playOne = false;
										
									}
								if (reverse == 1)
									{

										System.out.println("");
										
										playOne = false;

									}

							}
						while (playTwo)
							{
								System.out.flush();
								playOne = true;
								choice = 0;
								int reverse = 1;
								int counter = 0;
								System.out.println("The current card is " + currentCard.get(0).getColor() + " "
										+ currentCard.get(0).getNumber());
								System.out.println(" ");
								System.out.println("Player Twos turn");
								System.out.println(" ");
								System.out.println("You have " + playerTwo.size() + " cards left");
								System.out.println(" ");
								System.out.println("** PLAYABLE CARDS **");
								for (int i = 0; i < playerTwo.size(); i++)
									{
										if (currentCard.get(0).getColor() == playerTwo.get(i).getColor()
												|| currentCard.get(0).getNumber() == playerTwo.get(i).getNumber())
											{
												counter++;

												System.out
														.println("Type " + i + " to play " + playerTwo.get(i).getColor()
																+ " " + playerTwo.get(i).getNumber());

											}

									}
								for (int i = 0; i < playerTwo.size(); i++)
									{
										if (playerTwo.get(i).getColor() == "Wild")
											{
												counter++;
												Scanner userIntInput = new Scanner(System.in);
												System.out
														.println("Type " + i + " to play " + playerTwo.get(i).getColor()
																+ " " + playerTwo.get(i).getNumber());

											}
									}
								

								if (counter > 0)
									{
										System.out.println(" ");
										Scanner userIntInput = new Scanner(System.in);
										System.out.println("Type Number of card you want to play");
										choice = userIntInput.nextInt();
										currentCard.remove(0);
										currentCard.add(playerTwo.get(choice));

										if (playerTwo.get(choice).getNumber() == "Draw 4"
												)
											{
												System.out.println("");
												Scanner userIntInput2 = new Scanner(System.in);
												System.out.println(
														"Player 1 Draws 4 Cards and COLOR CHANGE, Type 1 for Blue, Type 2 for Red, Type 3 for Yellow, Type 4 for Green ");
												int colorChoice = userIntInput2.nextInt();
												if (colorChoice == 1)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Blue", "Wild"));
													}

												if (colorChoice == 2)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Red", "Wild"));
													}

												if (colorChoice == 3)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Yellow", "Wild"));
													}

												if (colorChoice == 4)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Green", "Wild"));
													}
												for (int i = 0; i < 4; i++)

													{
														playerTwo.add(Deck.deck.get(i));
														Deck.deck.remove(i);
													}
												
											}
										if (playerTwo.get(choice).getNumber() == "Color Change")
											{
												System.out.println("");
												Scanner userIntInput3 = new Scanner(System.in);
												System.out.println(
														"COLOR CHANGE. Type 1 for Blue, Type 2 for Red, Type 3 for Yellow, Type 4 for Green");
												int colorChoice2 = userIntInput3.nextInt();

												

												if (colorChoice2 == 1)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Blue", "Wild"));
													}

												if (colorChoice2 == 2)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Red", "Wild"));
													}

												if (colorChoice2 == 3)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Yellow", "Wild"));
													}

												if (colorChoice2 == 4)
													{
														currentCard.remove(0);
														currentCard.add(new Cards("Green", "Wild"));
													}
											}
										System.out.println("");
										
										if (playerTwo.get(choice).getNumber() == "Draw 2")
											{
												System.out.println("Player Two Draws 2 cards");
												for(int i = 0; i < 2; i++)
													{
														playerOne.add(Deck.deck.get(i));
														Deck.deck.remove(i);
													}
											}
										if (playerTwo.get(choice).getNumber() == "Reverse"
												|| playerTwo.get(choice).getNumber() == "Skip")
											{
												playerTwo.remove(choice);	
												System.out.println("Turn Skipped. Player Two plays again");
												reverse = 0;
											}
										playerTwo.remove(choice);
									}

								
								

								
								
								
								if(playerTwo.size() == 1)
									{
										Scanner userStringInput3= new Scanner(System.in);
										System.out.println("You have 1 card left type UNO");
										String UNO = userStringInput3.nextLine();
										if (UNO == "UNO")
											{
												System.out.println("PLAYER TWO HAS ONE CARD LEFT");
											}
									}
								
								if(playerTwo.size() == 0)
									{
										System.out.println("PLAYER TWO WINS");
										play = false;
									}

								if (counter == 0)
									{

										
										System.out.println(
												"you have no playable cards");
										System.out.println("Player 2 Draws 1 Card and now its player ones turn");
										playerTwo.add(Deck.deck.get(0));
										Deck.deck.remove(0);
										playTwo = false;
										
									}
								if (reverse == 1)
									{

										System.out.println("");
										
										playTwo = false;

									}


							}

					}

			}

	}
