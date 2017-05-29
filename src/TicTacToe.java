import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.util.Random;
public class TicTacToe extends javax.swing.JFrame {
//Define variables and arrays
    String[][] tac = new String[3][3];
    JButton[][] buttons = new JButton[3][3];
    int uwin=0;
    int cwin=0;
    int round=0;
    int tie=0;
    Random rand = new Random();
    int row;
    int col;
    String uchoice;
    String cchoice;
    String difficulty;
    String input;
    int level=0;
    int hardcount=0;
    //method to set disable all buttons
    public void setDisabled() {
       for (int x=0; x<=2;x++) {
            for (int y=0; y<=2; y++) {
                buttons[x][y].setEnabled(false);
            }
        }             
    }
    //method to enable all buttons
    public void setEnabled() {
       for (int x=0; x<=2;x++) {
            for (int y=0; y<=2; y++) {
                buttons[x][y].setEnabled(true);
            }
        }             
    }
    //method to rest required vairables and the array, as well as clear buttons
    public void reset(){
        for (int x=0; x<=2;x++) {
            for (int y=0; y<=2; y++) {
                tac[x][y]="";
                buttons[x][y].setText(tac[x][y]);
                System.out.println("ITEM: " + tac[x][y]);
            }
        }
        System.out.println("RESeT CALL");
        setDisabled();
        hardcount=0;
        Start.setEnabled(true);
    }
    //method to check for win or tie
    public void check() {
        int ccounter = 0;
        int ucounter=0;
        
         //Horizontal Check
    for(int a=0;a<3;a++){
        for(int b=0;b<3;b++){
            if(tac[a][b].equals(uchoice)){             
                ucounter++;
            }
            else if(tac[a][b].equals(cchoice)){
                ccounter++;
            } 
        }
            if(ucounter==3){
                JOptionPane.showMessageDialog(null,"You Win!");
                uwin++;
                reset();
            }
            else if(ccounter==3){
                JOptionPane.showMessageDialog(null,"Computer Wins!");
                cwin++;
                reset();
            }
        ucounter=0;
        ccounter=0;
    }  
    //Vertical Check
     for(int b=0;b<3;b++){
        for(int a=0;a<3;a++){
            if(tac[a][b].equals(uchoice)){             
                ucounter++;
            }
            else if(tac[a][b].equals(cchoice)){
                ccounter++;
            } 
        }
            if(ucounter==3){
                JOptionPane.showMessageDialog(null,"You Win!");
                uwin++;
                reset();
            }
            else if(ccounter==3){
                JOptionPane.showMessageDialog(null,"Computer Wins!");
                cwin++;
                reset();
            }
        ucounter=0;
        ccounter=0;
    } 
    //Diagonal Check
    if(tac[0][0].equals(uchoice)){
        if(tac[1][1].equals(uchoice)){
            if(tac[2][2].equals(uchoice)){
                JOptionPane.showMessageDialog(null,"You Win!!");
                uwin++;
                reset();
            }
        }
    }
    if(tac[0][2].equals(uchoice)){
        if(tac[1][1].equals(uchoice)){
            if(tac[2][0].equals(uchoice)){
                JOptionPane.showMessageDialog(null,"You Win!");
                uwin++;
                reset();
            }
        }
    }
    if(tac[0][0].equals(cchoice)){
        if(tac[1][1].equals(cchoice)){
            if(tac[2][2].equals(cchoice)){
                JOptionPane.showMessageDialog(null,"Computer Wins!");
                cwin++;
                reset();
            }
        }
    }
    if(tac[0][2].equals(cchoice)){
        if(tac[1][1].equals(cchoice)){
            if(tac[2][0].equals(cchoice)){
                JOptionPane.showMessageDialog(null,"Computer Wins!");
                cwin++;
                reset();
            }
        }
    }
    //check for Tie
    int check = 0;
    for(int x=0; x<3; x++) {
        for (int y=0; y<3; y++) {
            if (tac[x][y].equalsIgnoreCase(uchoice)||tac[x][y].equalsIgnoreCase(cchoice))
                check++;
        }
    }
    if (check==9) {
        JOptionPane.showMessageDialog(null,"Tie Game!");
        check=0;
        reset();
    }
    //record computer wins and user wins
    ComputerWins.setText("Computer: "+ String.valueOf(cwin));
    UserWins.setText("You: " + String.valueOf(uwin)); 
    }
    //method forr easy mode (simply take a random spot on the board
    public void easy () {
        //state variables
        int randrow=0;
        int randcol=0;
        String check;
        int count=0;
        int x = 0;
        //find as spot available
        while (x<1) {
            int randr = rand.nextInt(3);
            int randc = rand.nextInt(3);
            check = tac[randr][randc];
            if (check.equals("")) {
                randrow=randr;
                randcol=randc;
                x=1;   
            }
            count++;
            if (count==9) {
                x=1;
            }
        }
        //if there is a spot available, take it
        if (count!=9) {
        tac[randrow][randcol]=cchoice;
        buttons[randrow][randcol].setText(cchoice);
        buttons[randrow][randcol].setEnabled(false);
            check();
            count = 0;
        }
        //if count = 9 that means the whole board is taken up, so proceed to check method
        else {
            check();
        }
    }
    //method for medium mode, in this it blocks, or if a block isn't available places randomly
    public void medium () {
        int count=0;
        int checkav=0;
      check();
//place in middle of two user, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[0][y].equals(uchoice)&&tac[2][y].equals(uchoice)&&tac[1][y].equals("")) {
                    tac[1][y]=cchoice;
                    buttons[1][y].setText(cchoice);
                    buttons[1][y].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //place on left of two user, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[1][y].equals(uchoice)&&tac[2][y].equals(uchoice)&&tac[0][y].equals("")) {
                    tac[0][y]=cchoice;
                    buttons[0][y].setText(cchoice);
                    buttons[0][y].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //place on right of two user, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[0][y].equals(uchoice)&&tac[1][y].equals(uchoice)&&tac[2][y].equals("")) {
                    tac[2][y]=cchoice;
                    buttons[2][y].setText(cchoice);
                    buttons[2][y].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //place in middle of two user, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][0].equals(uchoice)&&tac[y][2].equals(uchoice)&&tac[y][1].equals("")) {
                    tac[y][1]=cchoice;
                    buttons[y][1].setText(cchoice);
                    buttons[y][1].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //place on left of two user, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][1].equals(uchoice)&&tac[y][2].equals(uchoice)&&tac[y][0].equals("")) {
                    tac[y][0]=cchoice;
                    buttons[y][0].setText(cchoice);
                    buttons[y][0].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //place right of two user, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][0].equals(uchoice)&&tac[y][1].equals(uchoice)&&tac[y][2].equals("")) {
                    tac[y][2]=cchoice;
                    buttons[y][2].setText(cchoice);
                    buttons[y][2].setEnabled(false);
                    checkav++;
                    check();
                }
            }
        //block user if he can potentially win diagonally
        //following four loops are for is user has the middle and a corner
        if (tac[1][1].equals(uchoice)) {
            if (tac[0][0].equals(uchoice)&&checkav==0) {
                tac[2][2].equals(cchoice);
                buttons[2][2].setText(cchoice);
                buttons[2][2].setEnabled(false);
                checkav++;
                check();
            }
                    
            if(tac[0][2].equals(uchoice)&&checkav==0) {
                tac[2][0].equals(cchoice);
                buttons[2][0].setText(cchoice);
                buttons[2][0].setEnabled(false);
                checkav++;
                check();
            }
                if (tac[2][0].equals(uchoice)&&checkav==0) {
                    tac[0][2].equals(cchoice);
                buttons[0][2].setText(cchoice);
                buttons[0][2].setEnabled(false);
                checkav++;
                check();
                }
                if(tac[2][2].equals(uchoice)&&checkav==0) {
                    tac[0][0].equals(cchoice);
                buttons[0][0].setText(cchoice);
                buttons[0][0].setEnabled(false);
                checkav++;
                check();
                }
        }
        ///followung two loops are if user has two corners 
        if (tac[0][0].equals(uchoice)&&tac[2][2].equals(uchoice)&&checkav==0) {
            tac[1][1]=cchoice;
            buttons[1][1].setText(cchoice);
            buttons[1][1].setEnabled(false);
            checkav++;
            check();
        }
        if (tac[0][2].equals(uchoice)&&tac[0][2].equals(uchoice)&&checkav==0) {
            tac[1][1]=cchoice;
            buttons[1][1].setText(cchoice);
            buttons[1][1].setEnabled(false);
            checkav++;
            check();
        }
        //if none of the previous cases were valied place randomly 
        if (checkav!=1) {
            easy();
        }
        else {
            checkav=0;
        }
        check();

}
    //method for the computer's first move for hard
   public void hard () {
       //if the middle is open (ie. user didn't place in the middle), take it
       if (tac[1][1].equals("")) {
            
        tac[1][1]=cchoice;
        buttons[1][1].setText(cchoice);
        buttons[1][1].setEnabled(false);
    }
       //if user did take the middle, take a corner
        if(tac[1][1].equals(uchoice)) {
            int randrow=0;
            int randcol=0;
            do {
               randrow=rand.nextInt(3);
               randcol=rand.nextInt(3);
            }
            while (randrow==1||randcol==1);
            tac[randrow][randcol]=cchoice;
            buttons[randrow][randcol].setText(cchoice);
            buttons[randrow][randcol].setEnabled(false);
        }
        check();
   }
   //method to go for a win, only used in hard mode
   public void win() {
       //place in middle of two comp, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[0][y].equals(cchoice)&&tac[2][y].equals(cchoice)&&tac[1][y].equals("")) {
                    tac[1][y]=cchoice;
                    buttons[1][y].setText(cchoice);
                    buttons[1][y].setEnabled(false);
                }
            }
        //place on left of two comp, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[1][y].equals(cchoice)&&tac[2][y].equals(cchoice)&&tac[0][y].equals("")) {
                    tac[0][y]=cchoice;
                    buttons[0][y].setText(cchoice);
                    buttons[0][y].setEnabled(false);
                }
            }
        //place on right of two comp, check left to right    
        for (int y=0; y<3; y++) {
                if (tac[0][y].equals(cchoice)&&tac[1][y].equals(cchoice)&&tac[2][y].equals("")) {
                    tac[2][y]=cchoice;
                    buttons[2][y].setText(cchoice);
                    buttons[2][y].setEnabled(false);
                }
            }
        //place in middle of two comp, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][0].equals(cchoice)&&tac[y][2].equals(cchoice)&&tac[y][1].equals("")) {
                    tac[y][1]=cchoice;
                    buttons[y][1].setText(cchoice);
                    buttons[y][1].setEnabled(false);
                }
            }
        //place on left of two comp, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][1].equals(cchoice)&&tac[y][2].equals(cchoice)&&tac[y][0].equals("")) {
                    tac[y][0]=cchoice;
                    buttons[y][0].setText(cchoice);
                    buttons[y][0].setEnabled(false);
                }
            }
        //place right of two comp, check top to bottom    
        for (int y=0; y<3; y++) {
                if (tac[y][0].equals(cchoice)&&tac[y][1].equals(cchoice)&&tac[y][2].equals("")) {
                    tac[y][2]=cchoice;
                    buttons[y][2].setText(cchoice);
                    buttons[y][2].setEnabled(false);
                }
            }
        //it won't be possible for user to win diagonally so case for that is not needed
   }
    
    
    public TicTacToe() {
        initComponents();
        //set up buttons array
        buttons[0][0] = l1;
        buttons[0][1] = m1;
        buttons[0][2] = r1;
        buttons[1][0] = l2;
        buttons[1][1] = m2;
        buttons[1][2] = r2;
        buttons[2][0] = l3;
        buttons[2][1] = m3;
        buttons[2][2] = r3;
        setDisabled();
        //clear board
        for (int x=0; x<=2;x++) {
            for (int y=0; y<=2; y++) {
                tac[x][y]="";
            }
        }
        Start.setEnabled(true);
        easybutton.setEnabled(false);
        medbutton.setEnabled(false);
        hardbutton.setEnabled(false);
        ComputerWins.setText("Computer: "+ String.valueOf(cwin));
        UserWins.setText("You: " + String.valueOf(uwin));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        l1 = new javax.swing.JButton();
        l2 = new javax.swing.JButton();
        m2 = new javax.swing.JButton();
        m1 = new javax.swing.JButton();
        r1 = new javax.swing.JButton();
        m3 = new javax.swing.JButton();
        r3 = new javax.swing.JButton();
        l3 = new javax.swing.JButton();
        r2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Start = new javax.swing.JButton();
        UserWins = new javax.swing.JLabel();
        ComputerWins = new javax.swing.JLabel();
        hardbutton = new javax.swing.JRadioButton();
        medbutton = new javax.swing.JRadioButton();
        easybutton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(new java.awt.Color(102, 102, 255));

        l1.setBackground(new java.awt.Color(255, 255, 255));
        l1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        l1.setForeground(new java.awt.Color(0, 0, 153));
        l1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1ActionPerformed(evt);
            }
        });

        l2.setBackground(new java.awt.Color(255, 255, 255));
        l2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        l2.setForeground(new java.awt.Color(0, 0, 153));
        l2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2ActionPerformed(evt);
            }
        });

        m2.setBackground(new java.awt.Color(255, 255, 255));
        m2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        m2.setForeground(new java.awt.Color(0, 0, 153));
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });

        m1.setBackground(new java.awt.Color(255, 255, 255));
        m1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        m1.setForeground(new java.awt.Color(0, 0, 153));
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });

        r1.setBackground(new java.awt.Color(255, 255, 255));
        r1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        r1.setForeground(new java.awt.Color(0, 0, 153));
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        m3.setBackground(new java.awt.Color(255, 255, 255));
        m3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        m3.setForeground(new java.awt.Color(0, 0, 153));
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3ActionPerformed(evt);
            }
        });

        r3.setBackground(new java.awt.Color(255, 255, 255));
        r3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        r3.setForeground(new java.awt.Color(0, 0, 153));
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        l3.setBackground(new java.awt.Color(255, 255, 255));
        l3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        l3.setForeground(new java.awt.Color(0, 0, 153));
        l3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l3ActionPerformed(evt);
            }
        });

        r2.setBackground(new java.awt.Color(255, 255, 255));
        r2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        r2.setForeground(new java.awt.Color(0, 0, 153));
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        Start.setBackground(new java.awt.Color(0, 255, 51));
        Start.setFont(new java.awt.Font("Bradley Hand ITC", 0, 24)); // NOI18N
        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        UserWins.setFont(new java.awt.Font("Bradley Hand ITC", 0, 18)); // NOI18N

        ComputerWins.setFont(new java.awt.Font("Bradley Hand ITC", 0, 18)); // NOI18N

        hardbutton.setFont(new java.awt.Font("Bradley Hand ITC", 0, 14)); // NOI18N
        hardbutton.setText("Hard");
        hardbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardbuttonActionPerformed(evt);
            }
        });

        medbutton.setFont(new java.awt.Font("Bradley Hand ITC", 0, 14)); // NOI18N
        medbutton.setText("Medium");
        medbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medbuttonActionPerformed(evt);
            }
        });

        easybutton.setFont(new java.awt.Font("Bradley Hand ITC", 0, 14)); // NOI18N
        easybutton.setText("Easy");
        easybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easybuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(hardbutton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(UserWins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medbutton)
                            .addComponent(easybutton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ComputerWins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(UserWins, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComputerWins, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(easybutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hardbutton)
                .addGap(18, 18, 18)
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tic-Tac-Toe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void l1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[0][0]=uchoice;
        buttons[0][0].setText(tac[0][0]);
        buttons[0][0].setEnabled(false);
        //easy mode 
        if (level==1) {           
            easy();
            check();
        }
        //medium 
        if (level==2) {
            medium();
            check();
        }
        //hard
        if (level==3) {
            //hard's first move
            if (hardcount==0) {
                hard();
                check();
                hardcount++;
            }
            //every move in hard after the first, try to win--->block--->random
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_l1ActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        //rest appropiate variables and clear board
        reset();
        //show radio buttons and make sure they aren't still selected
        easybutton.setSelected(false);
        medbutton.setSelected(false);
        hardbutton.setSelected(false);
        easybutton.setEnabled(true);
        medbutton.setEnabled(true);
        hardbutton.setEnabled(true);
        
        //set symbols (prev build allowed user able to select between x or o)
        uchoice = "X";
        cchoice = "O";


        Start.setEnabled(false);
    }//GEN-LAST:event_StartActionPerformed

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[0][1]=uchoice;
        buttons[0][1].setText(tac[0][1]);
        buttons[0][1].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_m1ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[0][2]=uchoice;
        buttons[0][2].setText(tac[0][2]);
        buttons[0][2].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_r1ActionPerformed

    private void l2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[1][0]=uchoice;
        buttons[1][0].setText(tac[1][0]);
        buttons[1][0].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_l2ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[1][1]=uchoice;
        buttons[1][1].setText(tac[1][1]);
        buttons[1][1].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_m2ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[1][2]=uchoice;
        buttons[1][2].setText(tac[1][2]);
        buttons[1][2].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_r2ActionPerformed

    private void l3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l3ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[2][0]=uchoice;
        buttons[2][0].setText(tac[2][0]);
        buttons[2][0].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_l3ActionPerformed

    private void m3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[2][1]=uchoice;
        buttons[2][1].setText(tac[2][1]);
        buttons[2][1].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_m3ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        //fill space, based on difficulty, computer places next
        tac[2][2]=uchoice;
        buttons[2][2].setText(tac[2][2]);
        buttons[2][2].setEnabled(false);
        if (level==1) {
            easy();
            check();
        }
        if (level==2) {
            medium();
            check();
        }
         if (level==3) {
            if (hardcount==0) {
                hard();
                hardcount++;
            }
            else {
                win();
                medium();
                check();
            }
        }
    }//GEN-LAST:event_r3ActionPerformed

    private void easybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easybuttonActionPerformed
        //if user picks easy button 
        level=1;
        easybutton.setEnabled(false);
        medbutton.setEnabled(false);
        hardbutton.setEnabled(false);
        
        medbutton.setSelected(false);
        hardbutton.setSelected(false);
        setEnabled();
    }//GEN-LAST:event_easybuttonActionPerformed

    private void medbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medbuttonActionPerformed
        //if user picks medium button
        level=2;
        easybutton.setEnabled(false);
        medbutton.setEnabled(false);
        hardbutton.setEnabled(false);
        
        easybutton.setSelected(false);
        hardbutton.setSelected(false);
        setEnabled();
    }//GEN-LAST:event_medbuttonActionPerformed

    private void hardbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardbuttonActionPerformed
        //if user picks hard method
        level=3;
        easybutton.setEnabled(false);
        medbutton.setEnabled(false);
        hardbutton.setEnabled(false);
        
        easybutton.setSelected(false);
        medbutton.setSelected(false);
        setEnabled();
    }//GEN-LAST:event_hardbuttonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ComputerWins;
    private javax.swing.JButton Start;
    private javax.swing.JLabel UserWins;
    private javax.swing.JRadioButton easybutton;
    private javax.swing.JRadioButton hardbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton l1;
    private javax.swing.JButton l2;
    private javax.swing.JButton l3;
    private javax.swing.JButton m1;
    private javax.swing.JButton m2;
    private javax.swing.JButton m3;
    private javax.swing.JRadioButton medbutton;
    private javax.swing.JButton r1;
    private javax.swing.JButton r2;
    private javax.swing.JButton r3;
    // End of variables declaration//GEN-END:variables
}
