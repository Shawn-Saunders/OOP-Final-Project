/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *the Main class to run the JFrame
 * @author Shawn Saunders & Ishaan Malhotra
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    // global variables for the row and column for the keyboard cursor
    int cursorRow = 0;
    int cursorCol = 0;
    
    // Create an array to hold all the information from each square
    JLabel[][] squareLabels = new JLabel[8][8];
    
    // Create an array to hold all the piece locations on the board
    Piece[][] board = new Piece[8][8];
    
    // Remembers which piece the player currently has picked up
    // null means nothing is selected right now
    Piece selectedPiece = null;
    
    // Allowed squares for the selected piece, null when nothing is selected
    int[][] validMoves = null; 
    
    // The player who's turn it currently is. Starts with black.
    String currentTurn = "black";
    // Boolean to see if one of the player has won, is set to true when conditions are met.
    boolean gameOver = false;
    
    // Global constant variables
    public final int BOARD_WIDTH = 8;
    public final int[][] BLACK_MOVEMENT = new int[][] {{1,-1},{1,1}};
    public final int[][] RED_MOVEMENT = new int[][] {{-1,1},{-1,-1}};
    public final int[][] KING_MOVEMENT = new int[][] {{1,1},{-1,-1},{1,-1},{-1,1}};
    public static final java.awt.Color CURSOR_HIGHLIGHT = new java.awt.Color(230, 194, 128);
    
    // Save/Load/Reset 
    private static final String SAVE_FILE = "savegame.txt";
    
    // Code for a square with nothing on it
    private static final String EMPTY_SQUARE = "-";
    
    // How the board looked before anybody moved.
    // The reset button puts this back.
    private final String[][] startingLayout = new String[8][8];
    
    // The three control buttons. Found out the way to write them instead so it doesn't mess with the current board.
    private javax.swing.JButton saveButton;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton resetButton;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        // Declare variables
        int index = 0;
        int row;
        int col;
        
        // Create objects for all red and black pieces
        for(Component square : gamePanel.getComponents())
        {
            JLabel piece = (JLabel) square;
            row = index / BOARD_WIDTH;
            col = index % BOARD_WIDTH;
            squareLabels[row][col] = piece;
            index++;
            if("black".equals(piece.getName())){
                board[row][col] = new Regular("black",row,col, BLACK_MOVEMENT);
            } else if ("red".equals(piece.getName())) {
                board[row][col] = new Regular("red",row,col, RED_MOVEMENT);
            } else if ("blackKing".equals(piece.getName())) {
                board[row][col] = new King("black",row,col, KING_MOVEMENT);
            } else if ("redKing".equals(piece.getName())){
                board[row][col] = new King("red",row,col, KING_MOVEMENT);
            }
        }
        
        // Remember what the board looked like before anybody moved.
        // Position the reset button restores.
        for (int r = 0; r < BOARD_WIDTH; r++) {
            for (int c = 0; c < BOARD_WIDTH; c++) {
                startingLayout[r][c] = (board[r][c] == null)
                        ? EMPTY_SQUARE
                        : imageNameFor(board[r][c]);
            }
        }
        
        // Add the buttons under the board
        buildControlPanel();
        
        // set the cursor and force the gamePanel to have focus
        moveCursor(cursorRow, cursorCol);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
    }
    
    //Builds the row of Save / Load / Reset buttons and puts them under the board
    private void buildControlPanel() {
        saveButton = new javax.swing.JButton("Save");
        loadButton = new javax.swing.JButton("Load");
        resetButton = new javax.swing.JButton("Reset");
        saveButton.setFocusable(false);
        loadButton.setFocusable(false);
        resetButton.setFocusable(false);
        
        saveButton.addActionListener(evt -> saveGame());
        loadButton.addActionListener(evt -> loadGame());
        resetButton.addActionListener(evt -> resetGame());
        
        javax.swing.JPanel controlPanel = new javax.swing.JPanel();
        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        controlPanel.add(resetButton);
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(gamePanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        squareLabel1 = new javax.swing.JLabel();
        squareLabel2 = new javax.swing.JLabel();
        squareLabel3 = new javax.swing.JLabel();
        squareLabel4 = new javax.swing.JLabel();
        squareLabel5 = new javax.swing.JLabel();
        squareLabel6 = new javax.swing.JLabel();
        squareLabel7 = new javax.swing.JLabel();
        squareLabel8 = new javax.swing.JLabel();
        squareLabel9 = new javax.swing.JLabel();
        squareLabel10 = new javax.swing.JLabel();
        squareLabel11 = new javax.swing.JLabel();
        squareLabel12 = new javax.swing.JLabel();
        squareLabel13 = new javax.swing.JLabel();
        squareLabel14 = new javax.swing.JLabel();
        squareLabel15 = new javax.swing.JLabel();
        squareLabel16 = new javax.swing.JLabel();
        squareLabel17 = new javax.swing.JLabel();
        squareLabel18 = new javax.swing.JLabel();
        squareLabel19 = new javax.swing.JLabel();
        squareLabel20 = new javax.swing.JLabel();
        squareLabel21 = new javax.swing.JLabel();
        squareLabel22 = new javax.swing.JLabel();
        squareLabel23 = new javax.swing.JLabel();
        squareLabel24 = new javax.swing.JLabel();
        squareLabel25 = new javax.swing.JLabel();
        squareLabel26 = new javax.swing.JLabel();
        squareLabel27 = new javax.swing.JLabel();
        squareLabel28 = new javax.swing.JLabel();
        squareLabel29 = new javax.swing.JLabel();
        squareLabel30 = new javax.swing.JLabel();
        squareLabel31 = new javax.swing.JLabel();
        squareLabel32 = new javax.swing.JLabel();
        squareLabel33 = new javax.swing.JLabel();
        squareLabel34 = new javax.swing.JLabel();
        squareLabel35 = new javax.swing.JLabel();
        squareLabel36 = new javax.swing.JLabel();
        squareLabel37 = new javax.swing.JLabel();
        squareLabel38 = new javax.swing.JLabel();
        squareLabel39 = new javax.swing.JLabel();
        squareLabel40 = new javax.swing.JLabel();
        squareLabel41 = new javax.swing.JLabel();
        squareLabel42 = new javax.swing.JLabel();
        squareLabel43 = new javax.swing.JLabel();
        squareLabel44 = new javax.swing.JLabel();
        squareLabel45 = new javax.swing.JLabel();
        squareLabel46 = new javax.swing.JLabel();
        squareLabel47 = new javax.swing.JLabel();
        squareLabel48 = new javax.swing.JLabel();
        squareLabel49 = new javax.swing.JLabel();
        squareLabel50 = new javax.swing.JLabel();
        squareLabel51 = new javax.swing.JLabel();
        squareLabel52 = new javax.swing.JLabel();
        squareLabel53 = new javax.swing.JLabel();
        squareLabel54 = new javax.swing.JLabel();
        squareLabel55 = new javax.swing.JLabel();
        squareLabel56 = new javax.swing.JLabel();
        squareLabel57 = new javax.swing.JLabel();
        squareLabel58 = new javax.swing.JLabel();
        squareLabel59 = new javax.swing.JLabel();
        squareLabel60 = new javax.swing.JLabel();
        squareLabel61 = new javax.swing.JLabel();
        squareLabel62 = new javax.swing.JLabel();
        squareLabel63 = new javax.swing.JLabel();
        squareLabel64 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel.setPreferredSize(new java.awt.Dimension(480, 480));
        gamePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gamePanelMousePressed(evt);
            }
        });
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gamePanelKeyPressed(evt);
            }
        });
        gamePanel.setLayout(new java.awt.GridLayout(8, 8));

        squareLabel1.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel1.setOpaque(true);
        squareLabel1.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel1);

        squareLabel2.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel2.setName("black"); // NOI18N
        squareLabel2.setOpaque(true);
        gamePanel.add(squareLabel2);

        squareLabel3.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel3.setOpaque(true);
        squareLabel3.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel3);

        squareLabel4.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel4.setName("black"); // NOI18N
        squareLabel4.setOpaque(true);
        gamePanel.add(squareLabel4);

        squareLabel5.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel5.setOpaque(true);
        squareLabel5.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel5);

        squareLabel6.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel6.setName("black"); // NOI18N
        squareLabel6.setOpaque(true);
        gamePanel.add(squareLabel6);

        squareLabel7.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel7.setOpaque(true);
        squareLabel7.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel7);

        squareLabel8.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel8.setName("black"); // NOI18N
        squareLabel8.setOpaque(true);
        gamePanel.add(squareLabel8);

        squareLabel9.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel9.setName("black"); // NOI18N
        squareLabel9.setOpaque(true);
        gamePanel.add(squareLabel9);

        squareLabel10.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel10.setOpaque(true);
        squareLabel10.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel10);

        squareLabel11.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel11.setName("black"); // NOI18N
        squareLabel11.setOpaque(true);
        gamePanel.add(squareLabel11);

        squareLabel12.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel12.setOpaque(true);
        squareLabel12.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel12);

        squareLabel13.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel13.setName("black"); // NOI18N
        squareLabel13.setOpaque(true);
        squareLabel13.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel13);

        squareLabel14.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel14.setOpaque(true);
        squareLabel14.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel14);

        squareLabel15.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel15.setName("black"); // NOI18N
        squareLabel15.setOpaque(true);
        gamePanel.add(squareLabel15);

        squareLabel16.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel16.setOpaque(true);
        squareLabel16.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel16);

        squareLabel17.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel17.setOpaque(true);
        squareLabel17.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel17);

        squareLabel18.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel18.setName("black"); // NOI18N
        squareLabel18.setOpaque(true);
        gamePanel.add(squareLabel18);

        squareLabel19.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel19.setOpaque(true);
        squareLabel19.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel19);

        squareLabel20.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel20.setName("black"); // NOI18N
        squareLabel20.setOpaque(true);
        gamePanel.add(squareLabel20);

        squareLabel21.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel21.setOpaque(true);
        squareLabel21.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel21);

        squareLabel22.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel22.setName("black"); // NOI18N
        squareLabel22.setOpaque(true);
        gamePanel.add(squareLabel22);

        squareLabel23.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel23.setOpaque(true);
        squareLabel23.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel23);

        squareLabel24.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        squareLabel24.setName("black"); // NOI18N
        squareLabel24.setOpaque(true);
        gamePanel.add(squareLabel24);

        squareLabel25.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel25.setOpaque(true);
        squareLabel25.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel25);

        squareLabel26.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel26.setOpaque(true);
        squareLabel26.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel26);

        squareLabel27.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel27.setOpaque(true);
        gamePanel.add(squareLabel27);

        squareLabel28.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel28.setOpaque(true);
        squareLabel28.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel28);

        squareLabel29.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel29.setOpaque(true);
        gamePanel.add(squareLabel29);

        squareLabel30.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel30.setOpaque(true);
        squareLabel30.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel30);

        squareLabel31.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel31.setOpaque(true);
        squareLabel31.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel31);

        squareLabel32.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel32.setOpaque(true);
        squareLabel32.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel32);

        squareLabel33.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel33.setOpaque(true);
        squareLabel33.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel33);

        squareLabel34.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel34.setOpaque(true);
        squareLabel34.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel34);

        squareLabel35.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel35.setOpaque(true);
        squareLabel35.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel35);

        squareLabel36.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel36.setOpaque(true);
        gamePanel.add(squareLabel36);

        squareLabel37.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel37.setOpaque(true);
        squareLabel37.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel37);

        squareLabel38.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel38.setOpaque(true);
        gamePanel.add(squareLabel38);

        squareLabel39.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel39.setOpaque(true);
        squareLabel39.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel39);

        squareLabel40.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel40.setOpaque(true);
        squareLabel40.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel40);

        squareLabel41.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel41.setName("red"); // NOI18N
        squareLabel41.setOpaque(true);
        gamePanel.add(squareLabel41);

        squareLabel42.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel42.setOpaque(true);
        squareLabel42.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel42);

        squareLabel43.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel43.setName("red"); // NOI18N
        squareLabel43.setOpaque(true);
        gamePanel.add(squareLabel43);

        squareLabel44.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel44.setOpaque(true);
        squareLabel44.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel44);

        squareLabel45.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel45.setName("red"); // NOI18N
        squareLabel45.setOpaque(true);
        gamePanel.add(squareLabel45);

        squareLabel46.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel46.setOpaque(true);
        squareLabel46.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel46);

        squareLabel47.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel47.setName("red"); // NOI18N
        squareLabel47.setOpaque(true);
        gamePanel.add(squareLabel47);

        squareLabel48.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel48.setOpaque(true);
        squareLabel48.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel48);

        squareLabel49.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel49.setOpaque(true);
        squareLabel49.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel49);

        squareLabel50.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel50.setName("red"); // NOI18N
        squareLabel50.setOpaque(true);
        squareLabel50.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel50);

        squareLabel51.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel51.setOpaque(true);
        squareLabel51.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel51);

        squareLabel52.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel52.setName("red"); // NOI18N
        squareLabel52.setOpaque(true);
        gamePanel.add(squareLabel52);

        squareLabel53.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel53.setOpaque(true);
        squareLabel53.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel53);

        squareLabel54.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel54.setName("red"); // NOI18N
        squareLabel54.setOpaque(true);
        gamePanel.add(squareLabel54);

        squareLabel55.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel55.setOpaque(true);
        squareLabel55.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel55);

        squareLabel56.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel56.setName("red"); // NOI18N
        squareLabel56.setOpaque(true);
        gamePanel.add(squareLabel56);

        squareLabel57.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel57.setName("red"); // NOI18N
        squareLabel57.setOpaque(true);
        gamePanel.add(squareLabel57);

        squareLabel58.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel58.setOpaque(true);
        squareLabel58.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel58);

        squareLabel59.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel59.setName("red"); // NOI18N
        squareLabel59.setOpaque(true);
        gamePanel.add(squareLabel59);

        squareLabel60.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel60.setOpaque(true);
        squareLabel60.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel60);

        squareLabel61.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel61.setName("red"); // NOI18N
        squareLabel61.setOpaque(true);
        gamePanel.add(squareLabel61);

        squareLabel62.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel62.setOpaque(true);
        squareLabel62.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel62);

        squareLabel63.setBackground(new java.awt.Color(50, 20, 5));
        squareLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        squareLabel63.setName("red"); // NOI18N
        squareLabel63.setOpaque(true);
        gamePanel.add(squareLabel63);

        squareLabel64.setBackground(new java.awt.Color(115, 55, 10));
        squareLabel64.setOpaque(true);
        squareLabel64.setPreferredSize(new java.awt.Dimension(60, 60));
        gamePanel.add(squareLabel64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gamePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamePanelMousePressed
        // Checks if somebody has already won and in that case ignores any further clicks.
        if (gameOver) return;
        
        
        try {
            final int SQUARE_SIZE = 60;
            int row = evt.getY() / SQUARE_SIZE;
            int col = evt.getX() / SQUARE_SIZE;
            handleActivatedSquare(row, col);

            // make sure the keyboard is still focused after a click event
            gamePanel.requestFocusInWindow();
        } catch (IllegalMoveException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Move", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Method to move the keyboard cursor to a new square
     * throw an exception if the user tries to move off the board
     * @param newRow The new row the cursor will be going to
     * @param newCol The new column the cursor will be going to
     */
    private void moveCursor(int newRow, int newCol) {
        if (newRow < 0 || newRow > BOARD_WIDTH - 1 || newCol < 0 || newCol > BOARD_WIDTH - 1) {
            // throw message was for testing purposes, the actual exceptions do not send a message
            throw new IllegalArgumentException("Cursor position (" + newRow + "," + newCol + ") is outside the board.");
        }
        
        // Restore the original background color of the previous square
        squareLabels[cursorRow][cursorCol].setBackground(baseColorFor(cursorRow, cursorCol));
        
        // update the active cursor position
        cursorRow = newRow;
        cursorCol = newCol;
        
        // color the new cursor position
        squareLabels[cursorRow][cursorCol].setBackground(CURSOR_HIGHLIGHT);
    }
    
    /**
     * A method that handles the logic of selecting a square 
     * @param row the selected row
     * @param col the selected column
     * @throws MainFrame.NoValidMovesException Exception to enforce if the piece has no valid moves
     * @throws MainFrame.IllegalMoveException  General Exception for any illegal moves
     */
    private void handleActivatedSquare(int row, int col) throws NoValidMovesException, IllegalMoveException{
        // Whatever piece is sitting on the square we just clicked
        // This is null if the square is empty
        Piece clickedPiece = board[row][col];
        
        // check the entire board for forced jump rule
        boolean boardHasJump = (bestCaptureCount(currentTurn) > 0);
        
        if (selectedPiece == null) {
            // First click, the player is trying to pick a piece up
            if (clickedPiece == null) {
                return;
            } else if (!clickedPiece.color.equals(currentTurn)){
                throw new IllegalMoveException("It is " + currentTurn + "'s turn, so that piece can't move.");
            } else {   
                
                // Clicked a different piece of their own, switch the selection to it
                int[][] allowedMoves = movesFor(clickedPiece);
                
                // check if the new piece has any valid moves available
                if (allowedMoves == null || allowedMoves.length == 0){
                    throw new NoValidMovesException("This piece has no valid moves available.");
                }
                
                selectedPiece = clickedPiece;
                validMoves = movesFor(selectedPiece);
                showGhostPieces();
                System.out.println("Selected the " + selectedPiece.color
                        + " piece at row " + row + ", col " + col);
                System.out.println("It has " + validMoves.length + " allowed move(s).");
            }
        } else {
            // The player is already holding a piece
        clearGhostPieces();
        if (isValidDestination(row, col)) {
                
                // check if the piece should be promoted during the move
                boolean shouldPromote = !(selectedPiece instanceof King)
                        && selectedPiece.crossedBackRank(board, row, col);

                // Removes any pieces we jump over
                for (int[] square : selectedPiece.getCapturesFor(board, row, col)) {
                    removePiece(square[0], square[1]);
                }
                movePiece(selectedPiece, row, col, shouldPromote);
                System.out.println("Moved to row " + row + ", col " + col);
                selectedPiece = null;
                validMoves = null;
                switchTurn();
                checkForGameOver();
            } else if (clickedPiece != null && clickedPiece.color.equals(currentTurn)) {
                
                // Clicked a different piece of their own, switch the selection to it
                int[][] allowedMoves = movesFor(clickedPiece);
                
                // check if the new piece has any valid moves available
                if (allowedMoves == null || allowedMoves.length == 0){
                    throw new NoValidMovesException("This piece has no valid moves available.");
                }
                
                // Clicked a different piece of their own, switch the selection to it
                selectedPiece = clickedPiece;
                validMoves = movesFor(selectedPiece);
                showGhostPieces();
                System.out.println("Switched to the piece at row " + row + ", col " + col);
                System.out.println("It has " + validMoves.length + " allowed move(s).");
            } else {
                selectedPiece = null;
                validMoves = null;
                throw new IllegalMoveException("Not a legal move for this piece."); 
            }
        }
        
        System.out.println("--------------------------");
    }//GEN-LAST:event_gamePanelMousePressed

    private void gamePanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gamePanelKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
            try {
                moveCursor(cursorRow - 1, cursorCol);
            } catch (IllegalArgumentException ex) {
                // Silently ignore the exception
            }
        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
            try {
                moveCursor(cursorRow + 1, cursorCol);
            } catch (IllegalArgumentException ex) {
                // Silently ignore the exception
            }
        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
            try {
                moveCursor(cursorRow, cursorCol - 1);
            } catch (IllegalArgumentException ex) {
                // Silently ignore the exception
            }
        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
            try {
                moveCursor(cursorRow, cursorCol + 1);
            } catch (IllegalArgumentException ex) {
                // Silently ignore the exception
            }
        }
        
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                handleActivatedSquare(cursorRow, cursorCol);
            } catch (IllegalMoveException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Move", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_gamePanelKeyPressed

    /**
     * A simple method to return a square to it's original color
     * after the cursor moves off the square
     * @param row the row the cursor is on
     * @param col the column the cursor is on
     * @return 
     */
    private java.awt.Color baseColorFor(int row, int col) {
    return (row + col) % 2 == 0
            ? new java.awt.Color(115, 55, 10)
            : new java.awt.Color(50, 20, 5);
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
    /**
     * Switches turns between the players
     */
    private void switchTurn() {
        if (currentTurn.equals("black")) {
            currentTurn = "red";
        } else {
            currentTurn = "black";
        }
        System.out.println("It is now " + currentTurn + "'s turn.");
    }
    /**
     * Checks if the destination is a legal move for the selected piece.
     * @param row The clicked row
     * @param col The clicked column
     * @return true if the square is in the validMoves 
     */
    private boolean isValidDestination(int row, int col) {
           if (validMoves == null) {
               return false;
           }

           // Compares the array numbers
           for (int[] move : validMoves) {
               if (move[0] == row && move[1] == col) {
                   return true;
               }
           }
           return false;
       }
       /**
     * Figures out which image file belongs to a piece 
     * @param piece The piece we need the image for
     * @return "black", "red", "blackKing" or "redKing" 
     */
    private String imageNameFor(Piece piece) {
            if (piece instanceof King) {
                return piece.color + "King";
            }
            return piece.color;
        } 
    /**
     * Remove the captured pieces from the board and the screen.
     * @param row The row of the piece being removed.
     * @param col The column of the piece being removed.
     */
    private void removePiece(int row, int col) {
        board[row][col] = null;
        squareLabels[row][col].setIcon(null);
        squareLabels[row][col].setName(null);
    }
    /**
     * Moves a piece to a new square and updates the board
     * @param piece The piece being moved
     * @param newRow The row it's being moved to
     * @param newCol The column it's being moved to
     */
    private void movePiece(Piece piece, int newRow, int newCol, boolean shouldPromote) {
        // Takes where it came from before we overwrite anything
        int oldRow = piece.row;
        int oldCol = piece.col;

        // check if the piece should have promoted during the move, 
        // if it has then promote the piece to king
        if (shouldPromote) {
            piece = new King(piece.color, newRow, newCol, KING_MOVEMENT); 
        }
        
        // Updates the logical board
        board[oldRow][oldCol] = null;
        board[newRow][newCol] = piece;
        
        
        // Updates the piece's own idea of where it is
        piece.row = newRow;
        piece.col = newCol;
        
        // Clears the square it left
        squareLabels[oldRow][oldCol].setIcon(null);
        squareLabels[oldRow][oldCol].setName(null);
        
        // Draws the piece on the square it arrived at
        // Shawn: I think this is where the kinging logic should go
        // if the king lands on rank 0 or rank 7 then change it to instance of king
        // also if the jump path set nowKing to true, then change the instance to king
        String imageName = imageNameFor(piece);
        squareLabels[newRow][newCol].setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/" + imageName + ".png")));
        squareLabels[newRow][newCol].setName(imageName);
    }
    
    /**
     * Generates a ghost piece where the piece can land
     * @param piece The last location of a path or the potential squares a piece can go to
     * @param newRow The row of the possible location
     * @param newCol The column of the possible location
     */
    public void showGhostPiece(Piece piece, int newRow, int newCol) {
        squareLabels[newRow][newCol].setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/greyCircle.png")));
    }
    /*
     * Draws a grey circle on every square the selected piece can move to
     */
    private void showGhostPieces() {
        if (validMoves == null) {
            return;
        }
        for (int[] move : validMoves) {
            showGhostPiece(selectedPiece, move[0], move[1]);
        }
    }

    /*
     * Removes the grey circles from the board.
    */
    private void clearGhostPieces() {
        if (validMoves == null) {
            return;
        }
        for (int[] move : validMoves) {
            squareLabels[move[0]][move[1]].setIcon(null);
        }
    }
    
    
    /**
     * Counts the number of pieces left of each color on the board.
     * @param color The color of piece we are counting for.
     * @return Number of pieces left of the color being checked.
     */
    private int countPieces(String color) {
        int count = 0;
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] != null && board[row][col].color.equals(color)) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Checks if the player still has any moves that they're allowed to make.
     * @param color The color of piece we are checking for.
     * @return true, if any piece of the color being checked has at least one valid move.
     */
    private boolean hasLegalMoves(String color) {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                Piece piece = board[row][col];
                // Only asks specific player's own pieces where they can go
                if (piece != null && piece.color.equals(color)) {
                    if (piece.getValidMoves(board).length > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Exception to be thrown when a player selects a piece with no valid moves
     */
    class NoValidMovesException extends IllegalMoveException {
        public NoValidMovesException(String message) {
            super(message);
        }
    }
    
    /**
     * General exception to be thrown when a player tries to
     * break the rules for movement
     */
    class IllegalMoveException extends IllegalArgumentException {
        public IllegalMoveException(String message){
            super(message);
        }
    }
    
    private void checkForGameOver() {
        // The player whose turn it is can still make moves and the game continues.
        if (hasLegalMoves(currentTurn)) {
            return;   
        }
        gameOver = true;
        String loser = currentTurn;
        String winner = loser.equals("black") ? "red" : "black";
        // Checks the reason player lost and prints a message accordingly.
        String reason;
        if (countPieces(loser) == 0) {
            reason = "All of " + loser + "'s pieces have been captured.";
        } else {
            reason = "The " + loser + " pieces have no legal moves left.";
        }

        String message = winner.toUpperCase() + " WINS!\n\n" + reason;
        System.out.println(message);
        JOptionPane.showMessageDialog(this, message, "Game Over",
                JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This checks the most amount of pieces a player could capture for their turn.
     * @param color The color we are checking.
     * @return Highest number of captures that are available, 0 if no jumps exist.
     */
    private int bestCaptureCount(String color) {
        int best = 0;
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.color.equals(color)) {
                    for (int[] move : piece.getValidMoves(board)) {
                        int captures = piece.getCapturesFor(board, move[0], move[1]).length;
                        if (captures > best) {
                            best = captures;
                        }
                    }
                }
            }
        }
        return best;
    }
    /**
     * 
     * @param piece the piece that the player is trying to move.
     * @return The square that the player is allowed to move to.
     */
    private int[][] movesFor(Piece piece) {
        int best = bestCaptureCount(piece.color);
        java.util.List<int[]> allowed = new java.util.ArrayList<>();
        for (int[] move : piece.getValidMoves(board)) {
            if (piece.getCapturesFor(board, move[0], move[1]).length == best) {
                allowed.add(move);
            }
        }
        return allowed.toArray(new int[0][]);
    }
    /**
     * Makes a piece into the short code we write into the save file.
     * @param piece The piece on the square, or null for an empty square
     * @return "black", "red", "blackKing", "redKing" or "-"
     */
    private String codeFor(Piece piece) {
        return (piece == null) ? EMPTY_SQUARE : imageNameFor(piece);
    }
    
    /**
     * Turns the code read out of the saved file back into a real object.
     * @param code One of "black", "red", "blackKing", "redKing" or "-"
     * @param row The row the piece belongs on
     * @param col The column the piece belongs on
     * @return A new Piece, or null if the square should be empty
     */
    private Piece pieceFor(String code, int row, int col) {
        switch (code) {
            case "black":
                return new Regular("black", row, col, BLACK_MOVEMENT);
            case "red":
                return new Regular("red", row, col, RED_MOVEMENT);
            case "blackKing":
                return new King("black", row, col, KING_MOVEMENT);
            case "redKing":
                return new King("red", row, col, KING_MOVEMENT);
            default:
                return null;
        }
    }
    
    /**
     * Writes the current state to the save file.
     * @return true if the file was written, false if something went wrong
     */
    private boolean writeSaveFile() {
        try (java.io.PrintWriter out = new java.io.PrintWriter(new java.io.FileWriter(SAVE_FILE))) {
            // Whose turn it is has to be saved too
            out.println(currentTurn);
            
            for (int row = 0; row < BOARD_WIDTH; row++) {
                StringBuilder line = new StringBuilder();
                for (int col = 0; col < BOARD_WIDTH; col++) {
                    if (col > 0) {
                        line.append(",");
                    }
                    line.append(codeFor(board[row][col]));
                }
                out.println(line);
            }
            return true;
        } catch (java.io.IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "The game could not be saved.\n" + ex.getMessage(),
                    "Save Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Save button. Writes the position to disk and tells the player where it went.
     */
    private void saveGame() {
        if (writeSaveFile()) {
            String path = new java.io.File(SAVE_FILE).getAbsolutePath();
            System.out.println("Game saved to " + path);
            JOptionPane.showMessageDialog(this, "Game saved to:\n" + path,
                    "Game Saved", JOptionPane.INFORMATION_MESSAGE);
        }
        gamePanel.requestFocusInWindow();
    }
    
    /**
     * Load button. Reads the save file and puts that position on the board.
     */
    private void loadGame() {
        java.io.File file = new java.io.File(SAVE_FILE);
        
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "There is no saved game to load yet.",
                    "Nothing To Load", JOptionPane.WARNING_MESSAGE);
            gamePanel.requestFocusInWindow();
            return;
        }
        
        // Loading throws away whatever game is on the board, so ask first
        int answer = JOptionPane.showConfirmDialog(this,
                "Load the saved game? The game on the board will be lost.",
                "Load Game", JOptionPane.YES_NO_OPTION);
        if (answer != JOptionPane.YES_OPTION) {
            gamePanel.requestFocusInWindow();
            return;
        }
        
        String turn;
        String[][] codes = new String[BOARD_WIDTH][BOARD_WIDTH];
        
        try (java.util.Scanner in = new java.util.Scanner(file)) {
            // First line is whose turn it is, then one line per row of the board
            turn = in.nextLine().trim();
            
            for (int row = 0; row < BOARD_WIDTH; row++) {
                codes[row] = in.nextLine().trim().split(",");
            }
        } catch (java.io.FileNotFoundException | java.util.NoSuchElementException ex) {
            JOptionPane.showMessageDialog(this, "The save file could not be read.",
                    "Load Failed", JOptionPane.ERROR_MESSAGE);
            gamePanel.requestFocusInWindow();
            return;
        }
        
        applyLayout(codes, turn);
        System.out.println("Game loaded. It is " + currentTurn + "'s turn.");
    }
    
    /**
     * Reset button. Puts the opening position back and updates the save file
     * match it.
     */
    private void resetGame() {
        int answer = JOptionPane.showConfirmDialog(this,
                "Start a new game? This also overwrites the save file.",
                "Reset Game", JOptionPane.YES_NO_OPTION);
        if (answer != JOptionPane.YES_OPTION) {
            gamePanel.requestFocusInWindow();
            return;
        }
        
        // Black always goes first at the start of a game
        applyLayout(startingLayout, "black");
        
        // Put the keyboard cursor back in the corner
        moveCursor(0, 0);
        
        // The save file now holds the opening position
        writeSaveFile();
        System.out.println("Board reset. It is " + currentTurn + "'s turn.");
    }
    
    /**
     * Rebuilds both the logical board and the visual board
     * @param codes An 8x8 grid of piece codes
     * @param turn The color that moves next, "black" or "red"
     */
    private void applyLayout(String[][] codes, String turn) {
        // Whatever the player had picked up belongs to the old position
        selectedPiece = null;
        validMoves = null;
        
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                String code = codes[row][col].trim();
                
                // Rebuild the logical board
                board[row][col] = pieceFor(code, row, col);
                
                // Rebuild the visual board so it matches.
                if (board[row][col] == null) {
                    squareLabels[row][col].setIcon(null);
                    squareLabels[row][col].setName(null);
                } else {
                    squareLabels[row][col].setIcon(new javax.swing.ImageIcon(
                            getClass().getResource("/" + code + ".png")));
                    squareLabels[row][col].setName(code);
                }
            }
        }
        
        currentTurn = turn;
        
        gameOver = false;
        checkForGameOver();
        
        gamePanel.requestFocusInWindow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel squareLabel1;
    private javax.swing.JLabel squareLabel10;
    private javax.swing.JLabel squareLabel11;
    private javax.swing.JLabel squareLabel12;
    private javax.swing.JLabel squareLabel13;
    private javax.swing.JLabel squareLabel14;
    private javax.swing.JLabel squareLabel15;
    private javax.swing.JLabel squareLabel16;
    private javax.swing.JLabel squareLabel17;
    private javax.swing.JLabel squareLabel18;
    private javax.swing.JLabel squareLabel19;
    private javax.swing.JLabel squareLabel2;
    private javax.swing.JLabel squareLabel20;
    private javax.swing.JLabel squareLabel21;
    private javax.swing.JLabel squareLabel22;
    private javax.swing.JLabel squareLabel23;
    private javax.swing.JLabel squareLabel24;
    private javax.swing.JLabel squareLabel25;
    private javax.swing.JLabel squareLabel26;
    private javax.swing.JLabel squareLabel27;
    private javax.swing.JLabel squareLabel28;
    private javax.swing.JLabel squareLabel29;
    private javax.swing.JLabel squareLabel3;
    private javax.swing.JLabel squareLabel30;
    private javax.swing.JLabel squareLabel31;
    private javax.swing.JLabel squareLabel32;
    private javax.swing.JLabel squareLabel33;
    private javax.swing.JLabel squareLabel34;
    private javax.swing.JLabel squareLabel35;
    private javax.swing.JLabel squareLabel36;
    private javax.swing.JLabel squareLabel37;
    private javax.swing.JLabel squareLabel38;
    private javax.swing.JLabel squareLabel39;
    private javax.swing.JLabel squareLabel4;
    private javax.swing.JLabel squareLabel40;
    private javax.swing.JLabel squareLabel41;
    private javax.swing.JLabel squareLabel42;
    private javax.swing.JLabel squareLabel43;
    private javax.swing.JLabel squareLabel44;
    private javax.swing.JLabel squareLabel45;
    private javax.swing.JLabel squareLabel46;
    private javax.swing.JLabel squareLabel47;
    private javax.swing.JLabel squareLabel48;
    private javax.swing.JLabel squareLabel49;
    private javax.swing.JLabel squareLabel5;
    private javax.swing.JLabel squareLabel50;
    private javax.swing.JLabel squareLabel51;
    private javax.swing.JLabel squareLabel52;
    private javax.swing.JLabel squareLabel53;
    private javax.swing.JLabel squareLabel54;
    private javax.swing.JLabel squareLabel55;
    private javax.swing.JLabel squareLabel56;
    private javax.swing.JLabel squareLabel57;
    private javax.swing.JLabel squareLabel58;
    private javax.swing.JLabel squareLabel59;
    private javax.swing.JLabel squareLabel6;
    private javax.swing.JLabel squareLabel60;
    private javax.swing.JLabel squareLabel61;
    private javax.swing.JLabel squareLabel62;
    private javax.swing.JLabel squareLabel63;
    private javax.swing.JLabel squareLabel64;
    private javax.swing.JLabel squareLabel7;
    private javax.swing.JLabel squareLabel8;
    private javax.swing.JLabel squareLabel9;
    // End of variables declaration//GEN-END:variables
}
