import java.util.Objects;

public class Shell {

    private FileSystem fileSystem;
    private Directory corrente;

    public Shell(){
        fileSystem = new FileSystem();
    }

    public void getComando(String s){
        String[] as = s.split(" ");
        Path p = new Path("");
        switch (as[0]) {
            case "ls":
                if(as.length == 1){
                    ls(p);
                    break;
                }
                p = new Path(as[1]);
                ls(p);
                break;
            case "size":
                if(as.length == 1){
                size(p);
                break;
            }
                p = new Path(as[1]);
                size(p);
                break;
            
            case "mkdir":
                p = new Path(as[1]);
                mkdir(p);
                break;
            case "mkfile":
                p = new Path(as[1]);
                int dim = Integer.parseInt(as[2]);
                mkfile(p, dim);
                break;
            case "cd":
            if(as.length == 1){
                cd(p);
                break;
            }
                p = new Path(as[1]);
                cd(p);
                break;
            case "pwd":
                pwd();
                break;
            default:
                break;
        }
    }

    public void ls(Path p){
        if(fileSystem.isEmpty()) return;
        System.out.println("ciao");
        Objects.nonNull(p);
        if(p.isEmpty()){
            System.out.println(corrente.showElements());
            return;
    }else
        System.out.println(fileSystem.getAllElementsOf(p));
    }

    public void size(Path p){
        Objects.nonNull(p);
        //corrente.getDimensione()
        if(p.isEmpty()){
            //System.out.println("ciao size");
            System.out.println(corrente.getDimensione());
            System.out.println(corrente.getNome());
            return;
        }
        System.out.println(p.toString());
        System.out.println(fileSystem.getDimensione(p));
    }

    public void mkdir(Path p){
        Objects.nonNull(p);
        //System.out.println(p.toString());
        Directory d = fileSystem.createDirectory(p);
        if(fileSystem.isEmpty()){
            fileSystem.insertRoot(new Radice(d.getNome()));
            corrente = fileSystem.getRoot();
            //System.out.println(corrente.getDimensione()); 0
            return;
        }
        //System.out.println(d.toString());
        fileSystem.insert(d);
    }

    public void mkfile(Path p,int dimensione){
        Objects.nonNull(p);
        File f = fileSystem.createFile(p, dimensione);
        fileSystem.insert(f);
    }

    public void cd(Path p){
        Objects.nonNull(p);
        if(p.isEmpty()){
            corrente = fileSystem.getRoot();
            return;
        }
        Entry e = fileSystem.getEntry(p);
        if(!(e instanceof Directory)) throw new IllegalArgumentException();
        corrente = (Directory) e;
    }

    public void pwd(){
        System.out.println(corrente.getNome());
    }

}
