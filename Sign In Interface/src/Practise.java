	/*
	public void CreateFile() {
		
		try {
			x = new Formatter("employeeBirthday.txt");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("could not create file");
		}
		
	}
	
	public void addRecord() {
		try {
			FileWriter add = new FileWriter("employeeBirthday.txt");
			add.write("l_name\tfirst_name\tD.O.B\tEmail");
			add.write("\n");
			add.write("Doe\tJohn\t1982/10/08\tjohn.doe@foobar.com");
			add.write("\n");
			add.write("Ann\tMary\t1995/05/10\tmary.jane@foobar.com");
			add.write("\n");
			add.write("Doe\tJane\t2020/02/15\tjane.doe@foobar.com");
			add.write("\n");
			add.write("Nyamz\tAlton\t1995/08/03\taltonn03@gmail.com");
			add.write("\n");
			add.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/*
	public void readFile(File fl) {
		
		try {
			//File myFile = new File("employeeBirthday.txt");
			Scanner read = new Scanner(fl);
			
			while(read.hasNextLine()) {
				String data = read.nextLine();
				String[] arr = data.split("\t");
				
				if(arr.length>0) {
					if(arr[2].equals("1995/08/03") ) {
						System.out.println("Birthday");
						
						JavaMail.sendMail(arr[1], arr[3], service);
						
					}
				}
				
				
				
				//System.out.println(data);
			}
			
			read.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	*/