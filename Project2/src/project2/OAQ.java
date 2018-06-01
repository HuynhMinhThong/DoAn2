/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author huynh minh thong
 */
public class OAQ extends javax.swing.JFrame {
    private int[] btn = new int[13];
    private int KhoA, KhoB, KtA, KtB;
    private boolean R1,R2 = true;
    
    /**
     * Creates new form OAQ
     */
    public OAQ() {
        initComponents();
        Begin();
        Update();
        LuocDi();
    }
    public void Add()
    {
        if((KhoA>5)&(KhoB>5))
        {
            if(R2==true)
            {
               for(int i=1;i<=5;i++)
               {
                   btn[i]=btn[i]+1;
               }
               KhoA=KhoA-5;
               this.btnKhoA.setText(""+KhoA);
               Update();
            }
            else
            {
                for(int i =6;i<=11;i++)
                {
                    btn[i]=btn[i]+1;
                }
                KhoB=KhoB-5;
                this.btnKhoB.setText(""+KhoB);
                Update();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(btn1,"Quân trong kho thấp hơn 5 quân: Không thể rãi quân");
        }
    }
    public void LuocDi()
    {
        if(R2==true)
        {
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
            btn11.setEnabled(false);
            JOptionPane.showMessageDialog(btn1,"Lược của A");
        }
        else
        {
             btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            btn10.setEnabled(true);
            btn11.setEnabled(true);
            JOptionPane.showMessageDialog(btn1,"Lược của B");
        }
    }
    public void WinLose()
    {
        if((btn[6]==0)&(btn[12]==0))
        {
            KhoA=KhoA+btn[1]+btn[2]+btn[3]+btn[4]+btn[5];
            this.btnKhoA.setText(""+KhoA);
            KhoB=KhoB+btn[7]+btn[8]+btn[9]+btn[10]+btn[11];
            this.btnKhoB.setText(""+KhoB);
            if(KhoA>KhoB)
            {
                JOptionPane.showMessageDialog(btn1,"Bên A thắng KhoA ="+KhoA+" KhoB"+KhoB);
                
            } 
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bên B thắng KhoA ="+KhoA+" KhoB"+KhoB);
            }
        }
    }
    public void Begin()
    {
        btn[1]=5;
        btn[2]=5;
        btn[3]=5;
        btn[4]=5;
        btn[5]=5;
        btn[6]=10;
        btn[7]=5;
        btn[8]=5;
        btn[9]=5;
        btn[10]=5;
        btn[11]=5;
        btn[12]=10;
        R2=true;
    }
    public void Update()
    {
        btn1.setText(""+btn[1]);
        btn2.setText(""+btn[2]);
        btn3.setText(""+btn[3]);
        btn4.setText(""+btn[4]);
        btn5.setText(""+btn[5]);
        btn6.setText(""+btn[6]);
        btn7.setText(""+btn[7]);
        btn8.setText(""+btn[8]);
        btn9.setText(""+btn[9]);
        btn10.setText(""+btn[10]);
        btn11.setText(""+btn[11]);
        btn12.setText(""+btn[12]);
    }
    public void Result(boolean kq,int bn)
    {
        if(kq==true)
        {
            KhoA=KhoA+btn[bn];
            this.btnKhoA.setText(""+KhoA);
        }
        else
        {
            KhoB=KhoB+btn[bn];
            this.btnKhoB.setText(""+KhoB);
        }
    }
    public void ResultRight(int t)
    {
        int thu=t;
        if(thu==12)
        {
            thu=1;
            if(btn[thu]==0)
            {
                JOptionPane.showMessageDialog(btn1,"Hai ô trông liên tiếp: Kết thúc lược");
            }
            else
            {
                Result(R1,thu);
                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[thu]);
                btn[thu]=0;
                Update();
                if(btn[thu+1]==0)
                {
                    ResultRight(thu+1);
                }
                else
                {
                    JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                }
            }
        }
        else
        {
            if(btn[thu+1]==0)
            {
                JOptionPane.showMessageDialog(btn1,"Hai ô trông liên tiếp: Kết thúc lược");
            }
            else
            {
                
                Result(R1,thu+1);
                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[thu+1]);
                btn[thu+1]=0;
                Update();
                if(thu+1!=12)
                {
                    if(btn[thu+2]==0)
                    {
                        ResultRight(thu+2);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                    }
                }
                else
                {
                    thu=1;
                    if(btn[thu]==0)
                    {
                        ResultRight(thu);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                    }
                }
            }
        }
    }
    public void ResultLeft(int t)
    {
        int thu=t;
        if(thu==1)
        {
            thu=12;
            if(btn[thu]==0)
            {
                JOptionPane.showMessageDialog(btn1,"Hai ô trông liên tiếp: Kết thúc lược");
            }
            else
            {
                
                Result(R1,thu);
                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[thu]);
                btn[thu]=0;
                Update();
                if(btn[thu-1]==0)
                {
                    ResultLeft(thu-1);
                }
                else
                {
                    JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                }
            }
        }
        else
        {
            if(btn[thu-1]==0)
            {
                JOptionPane.showMessageDialog(btn1,"Hai ô trông liên tiếp: Kết thúc lược");
            }
            else
            {
                
                Result(R1,thu-1);
                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[thu-1]);
                btn[thu-1]=0;
                Update();
                if(thu-1!=1)
                {
                    if(btn[thu-2]==0)
                    {
                        ResultLeft(thu-2);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                    }
                }
                else
                {
                    thu=12;
                    if(btn[thu]==0)
                    {
                        ResultLeft(thu);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btn1,"Kết thúc lược ");
                    }
                }
            }
        }
    }
    
    public void StartRight(int Thu, int GTri)
    {
        if(btn[Thu]==0)
        {
            ResultRight(Thu);
//            if(btn[Thu+1]==0)
//            {
//                JOptionPane.showMessageDialog(btn1,"Hai ô trông liên tiếp: Kết thúc lược");
//            }
//            else
//            {
//                KhoA=KhoA+btn[Thu+1];
//                this.btnKhoA.setText(""+KhoA);
//                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[Thu+1]);
//                btn[Thu+1]=0;
//                Update();
//            }    
        }
        else
        {
            int btnThu, btnGTri;
            btn[Thu]=0;
            btnThu=Thu;
            btnGTri=GTri;
            for(int i=1; i<=GTri;i++)
            {
                 if(btnThu!=12)
                 {
                    btn[btnThu+1]=btn[btnThu+1]+1;
                    btnGTri=btn[btnThu+1];
                    
                    btnThu++;
                 }
                else
                 {
                    btnThu=0;
                    btn[btnThu+1]=btn[btnThu+1]+1;
                    btnGTri=btn[btnThu+1];
                    btnThu++;
                 }
            }
            Update();
            JOptionPane.showMessageDialog(btn1,"Kết thúc lược Ô Thứ: "+btnThu+" có Số Quân: "+btnGTri);
            if((btnThu==5)||(btnThu==11))
            {
                JOptionPane.showMessageDialog(btn1,"Rải quân đến quan: Kết thúc lược");
            }
            else
            {
                if(btnThu!=12)
                {
                    StartRight(btnThu+1,btn[btnThu+1]);
                }
                else
                {
                    btnThu=1;
                    StartRight(btnThu,btn[btnThu]);
                }
            }   
        }
    }
    public void StartLeft(int Thu, int GTri)
    {
        if(btn[Thu]==0)
        {
            ResultLeft(Thu);
//            if(Thu!=1)
//            {
//                KhoA=KhoA+btn[Thu-1];
//                this.btnKhoA.setText(""+KhoA);
//                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[Thu-1]);
//                btn[Thu-1]=0;
//                Update();
//            }
//            else if(btn[Thu+1]==0)
//            {
//                JOptionPane.showMessageDialog(btn1,"Hai ô liên trông liên tiếp: Kết thúc lược");
//            }
//            else
//            {
//                Thu=12;
//                KhoA=KhoA+btn[Thu];
//                this.btnKhoA.setText(""+KhoA);
//                JOptionPane.showMessageDialog(btn1,"Kết thúc lược "+" Bạn đã ăn được: "+btn[Thu]);
//                btn[Thu]=0;
//                Update();
//            }
        }
        else
        {
            int btnThu, btnGTri;
            btn[Thu]=0;
            btnThu=Thu;
            btnGTri=GTri;
            for(int i=1; i<=GTri;i++)
            {
                if(btnThu!=1)
                {
                    btn[btnThu-1]=btn[btnThu-1]+1;
                    btnGTri=btn[btnThu-1];
                    btnThu--;
                }
                else
                {
                    btnThu=13;
                    btn[btnThu-1]=btn[btnThu-1]+1;
                    btnGTri=btn[btnThu-1];
                    btnThu--;
                }
            }
            Update();
            JOptionPane.showMessageDialog(btn1,"Kết thúc lược Ô Thứ: "+btnThu+" có Số Quân: "+btnGTri);
            if((btnThu==1)||(btnThu==7))
            {
                JOptionPane.showMessageDialog(btn1,"Rải quân đến quan: Kết thúc lược");
            }
            else
            {
                if(btnThu!=1)
                {
                    StartLeft(btnThu-1,btn[btnThu-1]);
                }
                else
                {
                    btnThu=12;
                    StartLeft(btnThu,btn[btnThu]);
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnKhoA = new javax.swing.JButton();
        pnBCo = new javax.swing.JPanel();
        btn12 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        rdbTrai = new javax.swing.JRadioButton();
        rdbPhai = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnKhoB = new javax.swing.JButton();
        btnRaQuan = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Kho A");

        btnKhoA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKhoA.setText("0");
        btnKhoA.setEnabled(false);

        pnBCo.setBackground(new java.awt.Color(0, 255, 255));
        pnBCo.setForeground(new java.awt.Color(51, 255, 255));

        btn12.setText("10");
        btn12.setEnabled(false);
        btn12.setPreferredSize(new java.awt.Dimension(75, 150));
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn1.setText("5");
        btn1.setPreferredSize(new java.awt.Dimension(75, 75));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("5");
        btn2.setPreferredSize(new java.awt.Dimension(75, 75));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("5");
        btn3.setPreferredSize(new java.awt.Dimension(75, 75));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("5");
        btn4.setPreferredSize(new java.awt.Dimension(75, 75));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.setPreferredSize(new java.awt.Dimension(75, 75));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(0, 51, 255));
        btn6.setText("5");
        btn6.setEnabled(false);
        btn6.setPreferredSize(new java.awt.Dimension(75, 75));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setText("5");
        btn7.setPreferredSize(new java.awt.Dimension(75, 75));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setText("5");
        btn8.setPreferredSize(new java.awt.Dimension(75, 75));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setText("5");
        btn9.setPreferredSize(new java.awt.Dimension(75, 75));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn10.setText("5");
        btn10.setPreferredSize(new java.awt.Dimension(75, 75));
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn11.setText("5");
        btn11.setPreferredSize(new java.awt.Dimension(75, 75));
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBCoLayout = new javax.swing.GroupLayout(pnBCo);
        pnBCo.setLayout(pnBCoLayout);
        pnBCoLayout.setHorizontalGroup(
            pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBCoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnBCoLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBCoLayout.createSequentialGroup()
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBCoLayout.setVerticalGroup(
            pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBCoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnBCoLayout.createSequentialGroup()
                        .addGroup(pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdbTrai);
        rdbTrai.setForeground(new java.awt.Color(102, 255, 255));
        rdbTrai.setText("Trái");

        rdbPhai.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbPhai);
        rdbPhai.setForeground(new java.awt.Color(102, 255, 255));
        rdbPhai.setText("Phải");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText(" Kho B");

        btnKhoB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKhoB.setText("0");
        btnKhoB.setEnabled(false);
        btnKhoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoBActionPerformed(evt);
            }
        });

        btnRaQuan.setBackground(new java.awt.Color(153, 153, 153));
        btnRaQuan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnRaQuan.setForeground(new java.awt.Color(0, 255, 255));
        btnRaQuan.setText("Thêm Quân");
        btnRaQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaQuanActionPerformed(evt);
            }
        });

        btnKetThuc.setBackground(new java.awt.Color(153, 153, 153));
        btnKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnKetThuc.setForeground(new java.awt.Color(0, 255, 255));
        btnKetThuc.setText("Kết thúc lược");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Game Ô Ăn Quan");

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\Project2\\img\\backgroud-go.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnKhoA, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(pnBCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(rdbPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(btnKhoB, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(690, 690, 690)
                .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(690, 690, 690)
                .addComponent(btnRaQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(rdbTrai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel2))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addGap(275, 275, 275)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addComponent(btnKhoA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(pnBCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(rdbPhai))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnKhoB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(btnRaQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(rdbTrai))
            .addComponent(jLabel2)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenuBar1.setBackground(new java.awt.Color(193, 100, 240));

        jMenu1.setText("Chức Năng");

        jMenuItem1.setText("Chơi Lại");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Thoát");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        if(btn[11]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=false;
            if(rdbPhai.isSelected()== true)
            {
                StartLeft(11,btn[11]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else if(rdbTrai.isSelected()==true)
            {
                StartRight(11,btn[11]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if(btn[1]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=true;
            if(rdbTrai.isSelected()== true)
            {
                StartLeft(1,btn[1]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else if(rdbPhai.isSelected()==true)
            {
                StartRight(1,btn[1]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(btn[2]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=true;
            if(rdbTrai.isSelected()== true)
            {
                StartLeft(2,btn[2]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else if(rdbPhai.isSelected()==true)
            {
                StartRight(2,btn[2]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
       if(btn[3]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=true;
            if(rdbTrai.isSelected()== true)
            {
                StartLeft(3,btn[3]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else if(rdbPhai.isSelected()==true)
            {
                StartRight(3,btn[3]);
                R2=false;
                LuocDi();
                WinLose();
            }
           else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
           
        }    
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if(btn[4]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=true;
            if(rdbTrai.isSelected()== true)
            {
                StartLeft(4,btn[4]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else if(rdbPhai.isSelected()==true)
            {
                StartRight(4,btn[4]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if(btn[5]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=true;
            if(rdbTrai.isSelected()== true)
            {
                StartLeft(5,btn[5]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else if(rdbPhai.isSelected()==true)
            {
                StartRight(5,btn[5]);
                R2=false;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if(btn[7]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=false;
            if(rdbPhai.isSelected()== true)
            {
                StartLeft(7,btn[7]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else if(rdbTrai.isSelected()==true)
            {
                StartRight(7,btn[7]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if(btn[8]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=false;
            if(rdbPhai.isSelected()== true)
            {
                StartLeft(8,btn[8]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else if(rdbTrai.isSelected()==true)
            {
                StartRight(8,btn[8]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if(btn[9]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=false;
            if(rdbPhai.isSelected()== true)
            {
                StartLeft(9,btn[9]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else if(rdbTrai.isSelected()==true)
            {
                StartRight(9,btn[9]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        if(btn[10]==0)
        {
            JOptionPane.showMessageDialog(btn1,"Ô có '0' quân mời bạn chọn ô khác ");
        }
        else
        {
            R1=false;
            if(rdbPhai.isSelected()== true)
            {
                StartLeft(10,btn[10]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else if(rdbTrai.isSelected()==true)
            {
                StartRight(10,btn[10]);
                R2=true;
                LuocDi();
                WinLose();
            }
            else
            {
                JOptionPane.showMessageDialog(btn1,"Bạn chưa chọn hướng đi ");
            }
            
        }
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        
    }//GEN-LAST:event_btn12ActionPerformed

    private void btnKhoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhoBActionPerformed

    private void btnRaQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaQuanActionPerformed
        Add();
    }//GEN-LAST:event_btnRaQuanActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        if(R2==true)
        {
            R2=false;
            LuocDi();
        }
        else
        {
            R2=true;
            LuocDi();
        }
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
   
    }//GEN-LAST:event_btn6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
            int output = JOptionPane.showConfirmDialog(btn1
               , "Bạn thật sự muốn bắt đầu lại? "
               ,"Game Ô ăn quan"
               ,JOptionPane.OK_CANCEL_OPTION);

            if(output == JOptionPane.OK_OPTION)
            {
               Begin();
               Update();
               KhoA=KhoB=0;
               this.btnKhoA.setText(""+KhoA);
               this.btnKhoB.setText(""+KhoB);
               LuocDi();
            }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       int output = JOptionPane.showConfirmDialog(btn1
               , "Bạn thật sự muốn thoát game"
               ,"Game Ô ăn quan"
               ,JOptionPane.OK_CANCEL_OPTION);

            if(output == JOptionPane.OK_OPTION)
            {
               System.exit(0);
            }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(OAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OAQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoA;
    private javax.swing.JButton btnKhoB;
    private javax.swing.JButton btnRaQuan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnBCo;
    private javax.swing.JRadioButton rdbPhai;
    private javax.swing.JRadioButton rdbTrai;
    // End of variables declaration//GEN-END:variables
}
