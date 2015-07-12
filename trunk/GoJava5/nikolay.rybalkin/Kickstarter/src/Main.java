import java.util.Arrays;

public class Main {

	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private ScanConsole scanConsole = new ScanConsole();
	private Output output = new Output();

	public Main(Categories categories, Projects projects) {

		this.categories = categories;
		this.projects = projects;
	}

	public void run() {

		Output output = new Output();

		QuoteGenerate generate = new QuoteGenerate();
		output.println(generate.quoteGenerate());

		while (true) {

			askCategory();

			int categoryIndex = scanConsole.consoleScan();
			Category category = shooseCategory(categoryIndex);

			if (category == null){
				continue;
			}

			Project[] foundProjects = projects.getProgects(category);
			printProjects(foundProjects);

			while (true) {

				ascProject(foundProjects);

				int projectIndex = scanConsole.consoleScan();

				if (projectIndex < 0 || foundProjects.length <=  projectIndex){
					output.println("Not true index: " + projectIndex);
					continue;
				}

				Project project = foundProjects[projectIndex];
				shooseProject(project);
				printProjectDetail(project);
			}
		}
	}

	private void ascProject(Project[] foundProjects) {

		int from = 0;
		int to = foundProjects.length - 1;
		output.println("Select project: [" + from + "..." +  to  + "]");
	}

	private void printProjectDetail(Project project) {

		output.println("Project detail:");
		printProject(project);

		String history = project.getHistory();
		if (history != null){
			output.println(history);
		}

		String video = project.getFAQ();
		if (video != null){
			output.println(video);
		}

		String faq = project.getFAQ();
		if (faq != null){
			output.println(faq);
		}

		output.println("---------------------------------------");
	}

	private void printProjects(Project[] foundProjects) {

		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			output.print((i + 1) + ") ");
			printProject(project);
        }
	}

	private void printProject(Project project) {

		output.println("Project name: " + project.getName());
		output.println("Description: " + project.getDescription());
		output.println("Need collected: " + project.getAmount() + "$");
		output.println("Already collected: " + project.getExist() + "$");
		output.println("Days remaining: " + project.getDays());
		output.println("---------------------------------------");
		output.println(SPACE);
	}

	private void askCategory() {

		output.println(SPACE);
		output.println("Select category: ");
		output.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory(int categoryIndex) {

		if ( categoryIndex <= 0 || categories.size() < categoryIndex){
			output.println("Not true index: " + categoryIndex);
			return null;
		}

		Category category = categories.get(categoryIndex - 1);
		output.println("You selected category: " + category.getName());
		return category;
	}

	private void shooseProject(Project project) {

		output.println("You selected project: " + project.getName());
	}

}

//��� ����� � ���� ����� ����������� ������� ������ ������� � ��������� ����������
//�������� 1: �������� � ������ �������� -> ���� ������ �� ����� ������� � ����� ���� "0 - �����" -> ������� 0 -> �������
//		� ���� ��������� -> ���� ������ ��������� � ����������� ������ ������ ���������
//		�������� 2: �������� � �������� ������� -> ���� ���� "0 - �����" -> ������� 0 -> ������� � ���� �������� -> ���� ������
//		�������� � ����������� ������ ������� �������

